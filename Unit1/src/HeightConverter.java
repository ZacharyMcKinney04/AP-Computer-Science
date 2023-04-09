import java.util.Scanner;
@SuppressWarnings("resource")
/**
 This program converts the user height in meters to feet and inches
*/

public class HeightConverter {
    public static void main(String[] args) {
        double userMeter;
        String name;
        final double METER_TO_INCH = 39.3701;
        int userFeet;
        int remainderInch;
        final int INCHES_PER_FOOT = 12;
        double totalInches;
        Scanner in = new Scanner(System.in); 

        //name input
        System.out.print("Name: ");
        name = in.nextLine();
        System.out.println("Hi, " + name);

        //height input
        System.out.print("Height in Meters: ");
        userMeter = in.nextDouble();
        totalInches = (userMeter * METER_TO_INCH);
        userFeet = (int) (totalInches/INCHES_PER_FOOT);
        remainderInch = (int) (totalInches%INCHES_PER_FOOT);
        System.out.printf("Your height in feet and inches is: %d\' %d\"\n", userFeet, remainderInch);
    }

    
}
