package lr1;

import java.util.Calendar;
import java.util.Scanner;

public class example10 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            {
                System.out.println("введите год рождения");
            }
            int yearOfBirth = scanner.nextInt();

            int yearsOld = Calendar.getInstance().get(Calendar.YEAR  )  - yearOfBirth;
            System.out.print(yearsOld + " лет");
            scanner.close();
        }
}
