import java.util.Scanner;
/*
Write a program that converts a total number of seconds to hours, minutes, and seconds.
 (1) prompt the user for input, 
 (2) read an integer from the keyboard, 
 (3) calculate the result, and 
 (4) use printf to display the output. 
 For example, "5000 seconds = 1 hours, 23 minutes, and 20 seconds".
Hint: Use the remainder operator.
 */
@SuppressWarnings("resource")
public class TimeConversion {
    public static void main(String[] args) {
        int inputSeconds;
        int hours;
        int minutes;
        int seconds;
        final int HOUR_CONVERSION = 3600;
        final int MINUTE_CONVERSION = 60;
        Scanner in = new Scanner(System.in); 

        //name input
        System.out.print("Number of Seconds: ");
        inputSeconds = in.nextInt();
        hours = inputSeconds/HOUR_CONVERSION;
        minutes = (inputSeconds%HOUR_CONVERSION)/MINUTE_CONVERSION;
        seconds = (inputSeconds%HOUR_CONVERSION)%MINUTE_CONVERSION;
        System.out.printf("%d seconds = %d hours, ", inputSeconds, hours);
        System.out.printf("%d minutes, and %d seconds \n", minutes, seconds);

    }

}
