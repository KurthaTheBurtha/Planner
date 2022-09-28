import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    }
}
