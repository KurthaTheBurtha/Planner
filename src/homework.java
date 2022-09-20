import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class homework {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        HashMap<String,String> assignments = new HashMap<String,String>();
        System.out.println("Add assignment - 1: Remove Assignment - 2: Modify Assignment - 3: View Assignments - 4");
        String response = in.nextLine();
        String ans = "";
        //add assignment
        while(true) {
            if (response.equals("1")) {
                System.out.println("Due Date");
                String duedate = in.nextLine();
                System.out.println("Assignment Name");
                String assname = in.nextLine();
                System.out.println("Would you like to add another one?");
                ans = in.nextLine();
                if(ans.equalsIgnoreCase("n")){
                    ans="";
                    break;
                }
            }
            else if(response.equals("2")){

            }
            else if(response.equals("3")){

            }
            else if(response.equals("4")){
                int num=1;
                for (HashMap.Entry<String,String> s : assignments.entrySet()){
                    System.out.print(num+". ");
                    System.out.println(s.getValue()+" | due "+s.getKey());
                }
            } else {
                System.out.println("Would you like to do anything else?");
                ans = in.nextLine();
                if (ans.equalsIgnoreCase("n")) {
                    ans = "";
                    break;
                }
            }
        }

    }

}
