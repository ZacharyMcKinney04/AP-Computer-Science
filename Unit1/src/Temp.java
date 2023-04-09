import java.util.Scanner;
/*Exercise 2  
Write a program that converts a temperature from Celsius to Fahrenheit. It should 
(1) prompt the user for input, 
(2) read a double value from the keyboard, 
(3) calculate the result, and 
(4) format the output to one decimal place.
 When it’s finished, it should work like this:
Enter a temperature in Celsius: 24
24.0 C = 75.2 F
Here is the formula to do the conversion:
F = C × 9/5 + 32
Hint: Be careful not to use integer division!
*/
@SuppressWarnings("resource")
public class Temp {
    public static void main(String[] args) {
        double celsius;
        double fahrenheitConversion;
        Scanner in = new Scanner(System.in);

        //celsius input
        System.out.print("Tempature in Celsius: ");
        celsius = in.nextDouble();
        fahrenheitConversion = (celsius * 9/5) + 32;
        System.out.printf("Your temperature in fahrenheit is %.1f \n", fahrenheitConversion);

    }

    
}