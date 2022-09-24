
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class homework {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("work"));
        String line ="";
        String ddate;
        String assn;
        String sub;
        HashMap<String, ArrayList<String>> assignments = new HashMap<String,ArrayList<String>>();
        while(file.hasNextLine()) {
            line = file.nextLine();
            ddate = line.substring(0,line.indexOf(" | "));
            assn = line.substring(line.indexOf(" | ")+3);
            if(!(assignments.containsKey(ddate))) {
                assignments.put(ddate, new ArrayList<String>());
            }
//            if(assn.contains(",")){
//                assignments.get(ddate).add(assn.substring(0,assn.indexOf(",")));
//                for(int i = 1; i<=commaCount(assn)-1;i++){
//
//                    assignments.get(ddate).add(assn.substring(assn.indexOf(",")));
//                }
//            } else {
//                assignments.get(ddate).add(assn);
//            }
        }
        Scanner in = new Scanner(System.in);
        System.out.print("Add assignment - 1: Remove Assignment - 2: View Assignments - 3: Clear Assignments - 4 | ");
        String response = in.nextLine();
        String ans = "";
        while(true) {
            if (response.equals("1")) {
                add(assignments);
            }
            else if(response.equals("2")){
                remove(assignments);
            }
            else if(response.equals("3")){
                print(assignments);
            }
            else if(response.equals("4")){
                assignments.clear();
            }
                System.out.println("Would you like to do anything else?");
                ans = in.nextLine();
                if (ans.equalsIgnoreCase("n")) {
                    ans = "";
                    break;
                } else {
                    System.out.print("Add assignment - 1: Remove Assignment - 2: View Assignments - 3: Clear Assignments - 4 | ");
                    response = in.nextLine();
                }


        }
        writeToFile(assignments);
        print(assignments);
    }
    //prints a hashmap
    public static void print(HashMap<String,ArrayList<String>> assignments){
        int num=1;
        for (HashMap.Entry<String,ArrayList<String>> s : assignments.entrySet()){
            System.out.print(num+". ");
            System.out.print(s.getKey()+" | ");
            for(int i = 1; i<=assignments.get(s.getKey()).size();i++){
                if(i==assignments.get(s.getKey()).size()) {
                    System.out.print(s.getValue().get(i - 1));
                } else{
                    System.out.print(s.getValue().get(i - 1)+",");
                }
            }
            System.out.println();
            num++;
        }
    }
    //adds an element to the HashMap
    public static HashMap<String,ArrayList<String>> add(HashMap<String,ArrayList<String>> assignments){
        Scanner in = new Scanner(System.in);
        String ans = "";
        System.out.println("Due Date");
        String duedate = in.nextLine();
        System.out.println("Assignment Name");
        String assname = in.nextLine();
        if(!(assignments.containsKey(duedate))) {
            assignments.put(duedate, new ArrayList<String>());
        }
        assignments.get(duedate).add(assname);
        System.out.println("Would you like to add another one?");
        ans = in.nextLine();
        if(ans.equalsIgnoreCase("y")){
            add(assignments);
        }
        return assignments;
    }
    //removes an element from a HashMap
    public static HashMap<String,ArrayList<String>> remove(HashMap<String,ArrayList<String>> assignments){
        Scanner in = new Scanner(System.in);
        System.out.println("Which one would you like to remove? Enter a number");
        print(assignments);
        int ans = Integer.parseInt(in.nextLine());
        int num=1;
        for (HashMap.Entry<String,ArrayList<String>> s : assignments.entrySet()){
            if(num==ans){
                System.out.println("Which one would you like to remove?");
                for(int i = 1; i<=assignments.get(s.getKey()).size();i++){
                    System.out.println(i+". "+s.getValue().get(i-1));
                }
                int ans2 = Integer.parseInt(in.nextLine());
                s.getValue().remove(ans2-1);
                break;
            }
            num++;
        }
        return assignments;
    }
    //writes elements from a HashMap to the file "assignments"
    public static void writeToFile(HashMap<String,ArrayList<String>> assignments) throws IOException {
        FileWriter fileWriter = new FileWriter("work");
        for (HashMap.Entry<String,ArrayList<String>> s : assignments.entrySet()) {
            fileWriter.write(s.getKey() + " | ");
            for(int i = 1; i<=assignments.get(s.getKey()).size();i++){
                if(i==assignments.get(s.getKey()).size()) {
                    fileWriter.write(s.getValue().get(i - 1));
                } else{
                    fileWriter.write(s.getValue().get(i - 1)+",");
                }
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
    public static int commaCount(String assignment){
        int count =0;
        for(int i = 0; i<assignment.length();i++){
            if(assignment.charAt(i)==','){
                count++;
            }
        }
        return count;
    }


}
