import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class testing {
    public static void main(String[] args) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        String strDate = dateFormat.format(date);
        System.out.println("Converted String: " + strDate);
//        int dashindex = strDate.indexOf("-");
//        String strmonth = strDate.substring(dashindex+1,dashindex+3);
//        String strday = strDate.substring(dashindex+4,dashindex+7);
//        System.out.println(strmonth);
//        System.out.println(strday);
        System.out.println(isLater("09/28/2022","09/27/2022"));
        System.out.println(isLater("09/28/2022","09/28/2022"));
        System.out.println(isLater("09/28/2022","09/29/2022"));
        System.out.println(isLater("09/28/2022","10/29/2022"));
        System.out.println(isLater("1/23/2022","12/27/2021"));
        ArrayList<Assignment> assignments = new ArrayList<>();
        Assignment a = new Assignment("penis","poo","09/28/2022","Tuesday");
        Assignment b = new Assignment("butt","poo","09/31/2022","Wednesday");
        assignments.add(b);
        assignments.add(a);
    }
    //dates come in the form MM/dd
    public static boolean isLater(String date1, String date2){
        int month1 = Integer.parseInt(date1.substring(0,date1.indexOf("/")));
        int day1 = Integer.parseInt(date1.substring(date1.indexOf("/")+1,date1.indexOf("/",3)));
        int year1= Integer.parseInt(date1.substring(date1.indexOf("/",3)+1));
        int month2 = Integer.parseInt(date2.substring(0,date2.indexOf("/")));
        int day2 = Integer.parseInt(date2.substring(date2.indexOf("/")+1,date1.indexOf("/",3)));
        int year2 = Integer.parseInt(date2.substring(date2.indexOf("/",3)+1));
        if(year2>year1){
            return true;
        } else if(month2==12&&month1<12){
            return true;
        } else if(month1>month2){
            return true;
        }else if(day1>day2){
            return true;
        }
        return false;
    }
    //sorts the arraylist by due date
    public static void sort(ArrayList<Assignment> assignments){
        Assignment temp;
        for(int i = 0; i< assignments.size()-1;i++){
            for(int j = 0; j<assignments.size()-1-i;j++){
                if(isLater(assignments.get(j).duedate,assignments.get(j+1).duedate)){
//                    swap
                }
            }
        }
    }
//    public static void swap(ArrayList<Assignment> a, int index1, int index2){
//        ArrayList<Assignment>
//    }

}
