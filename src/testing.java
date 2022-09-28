import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class testing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
//        Date date = formatter.parse(word);
        System.out.println("date");
    }
}
