package Exercises;
import java.util.Scanner;

/**
 * Demonstrates input validation using if statements.
 */
 
public class Logarithm {
    
    public static void main(String[] args) {
        // prompt for input
        System.out.print("Enter a number: ");
        Scanner in = new Scanner(System.in);

        // check the format
        if (!in.hasNextDouble()) {
            String word = in.next();
            System.err.println(word + " is not a number");
            in.close();
            return;
        }
        
        // check the range
        double x = in.nextDouble();
        if (x > 0) {
            double y = Math.log(x);
            System.out.println("The log is " + y);
        } else {
            System.out.println("The log is undefined");
        } 

        in.close();

    }

}