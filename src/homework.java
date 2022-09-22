
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class homework {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        HashMap<String,String> assignments = new HashMap<String,String>();
        System.out.println("Add assignment - 1: Remove Assignment - 2: View Assignments - 3");
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
                System.out.println("Would you like to do anything else?");
                ans = in.nextLine();
                if (ans.equalsIgnoreCase("n")) {
                    ans = "";
                    break;
                } else {
                    System.out.println("Add assignment - 1: Remove Assignment - 2: Modify Assignment - 3: View Assignments - 4");
                    response = in.nextLine();
                }

        }
        print(assignments);

    }
    //prints a hashmap
    public static void print(HashMap<String,String> assignments){
        int num=1;
        for (HashMap.Entry<String,String> s : assignments.entrySet()){
            System.out.print(num+". ");
            System.out.println(s.getValue()+" | due "+s.getKey());
            num++;
        }
    }
    //adds an element to the HashMap
    public static HashMap<String,String> add(HashMap<String,String> assignments){
        Scanner in = new Scanner(System.in);
        String ans = "";
        System.out.println("Due Date");
        String duedate = in.nextLine();
        System.out.println("Assignment Name");
        String assname = in.nextLine();
        assignments.put(duedate,assname);
        System.out.println("Would you like to add another one?");
        ans = in.nextLine();
        if(ans.equalsIgnoreCase("y")){
            add(assignments);
        }
        return assignments;
    }
    //removes an element from a HashMap
    public static HashMap<String,String> remove(HashMap<String,String> assignments){
        Scanner in = new Scanner(System.in);
        System.out.println("Which one would you like to remove? Enter a number");
        print(assignments);
        int ans = Integer.parseInt(in.nextLine());
        int num=1;
        for (HashMap.Entry<String,String> s : assignments.entrySet()){
            if(num==ans){
                assignments.remove(s.getKey(),s.getValue());
                break;
            }
            num++;
        }
        return assignments;
    }

}
