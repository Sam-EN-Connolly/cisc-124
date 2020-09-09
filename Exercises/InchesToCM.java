package Exercises;
import java.util.Scanner;

/**
 * Converts inches to cm.
 */

public class InchesToCM {
    public static void main (String[] args) { 
        double inch;
        double cm;
        
        final double CM_PER_INCH = 2.54;
        
        Scanner in = new Scanner(System.in);

        System.out.print("How many inches to convert to cm? ");
        inch = in.nextDouble();

        cm = inch * CM_PER_INCH;

        System.out.printf("%.2f inches is %.2fcm.", inch, cm);

        in.close();
    }
}