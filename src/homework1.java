import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class homework1
{
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<Assignment> assignments= readFile();
        System.out.print("Add assignments - 1: Remove Assignment - 2: View Assignments - 3: Clear Assignments - 4 | ");
        String response = input.nextLine();
        String ans;
        while(true) {
            switch (response) {
                case "1" -> add(assignments);
                case "2" -> remove(assignments);
                case "3" -> print(assignments);
                case "4" -> assignments.clear();
            }
            System.out.println("Would you like to do anything else?");
            ans = input.nextLine();
            if (ans.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.print("Add assignments - 1: Remove Assignment - 2: View Assignments - 3: Clear Assignments - 4 | ");
                response = input.nextLine();
            }
        }
        print(assignments);
        writeToFile(assignments);
    }
    //reads the file and converts it into an arraylist
    public static ArrayList<Assignment> readFile() throws IOException{
        ArrayList<Assignment> assignments= new ArrayList<>();
        Scanner file = new Scanner(new File("work"));
        while(file.hasNextLine()){
            String line = file.nextLine();
            String subject = line.substring(0,line.indexOf("|")-1);
            String name = line.substring(line.indexOf("|")+2,line.indexOf("-")-1);
            String dueday = line.substring(line.indexOf("-")+2,line.indexOf("."));
            String duedate = line.substring(line.indexOf(".")+1);
            Assignment a = new Assignment(name,subject,duedate,dueday);
            assignments.add(a);
        }
        return assignments;
    }
    //prints out datapoints inside the arraylist
    public static void print(ArrayList<Assignment> assignments){
        int num = 1;
        for(Assignment a: assignments){
            System.out.print(num+". ");
            System.out.println(a.format());
            num++;
        }
        System.out.println();
    }
    //adds elements to the arraylist
    public static void add(ArrayList<Assignment> assignments) {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.print("Name of the assignment: ");
            String name = input.nextLine();
            System.out.print("Subject: ");
            String subject = input.nextLine();
            System.out.print("Due Day: ");
            String dueday = input.nextLine();
            System.out.print("Due Date: ");
            String duedate = input.nextLine();
            Assignment a = new Assignment(name, subject, duedate, dueday);
            assignments.add(a);
            System.out.print("Would you like to add another assignment?");
            String response = input.nextLine();
            if(response.equalsIgnoreCase("n")){
                break;
            }
        }
    }
    //removes an elements from the arraylist
    public static void remove(ArrayList<Assignment> assignments) {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Which assignment would you like to remove? Type a number. Type anything else to stop");
            print(assignments);
            String response = input.nextLine();
            if(isNumeric(response)) {
                int num = Integer.parseInt(response);
                try {
                    assignments.remove(num-1);
                } catch (Exception e){
                    System.out.println("Not a Valid Number. Try Again");
                }
            } else {
                break;
            }
        }
    }
    //checks if a number isNumeric
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    //writes the elements in the arraylist into the file
    public static void writeToFile(ArrayList<Assignment> assignments) throws IOException{
        FileWriter writer = new FileWriter("work");
        for(Assignment a: assignments) {
            writer.write(a.format());
            writer.write("\n");
        }
        writer.close();
    }

}
