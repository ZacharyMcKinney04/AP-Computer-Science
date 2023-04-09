import java.util.Scanner;
@SuppressWarnings("resource")
public class Quadratic {
    public static void main(String[] args){
        int a = askInteger("a");
        int b = askInteger("b");
        int c = askInteger("c");
        isValid(a, b, c);
        }

    public static int askInteger(String inputLetter){
        Scanner in = new Scanner(System.in);
        System.out.print("What is integer \"" + inputLetter + "\"? ");
        int outputNumber = 0;
        if(in.hasNextInt()){
            outputNumber = in.nextInt();
        } else {
            String word = in.next();
            System.err.println(word + "is not a number");
            System.err.println("Automatically Setting to 0");
        }
        return outputNumber;
    }

    public static void isValid(int a, int b, int c){
        if ( ((b*b) - (4*a*c)) <= 0 ){
            System.out.println("Imaginary Numbers or 0 in root");
        } else if ((a*2) == 0){
            System.out.println("Undefined, division by 0");
        } else {
            System.out.println("These numbers are allowed");
            quadraticFormula(a, b, c);
        }
    }

    public static void quadraticFormula(double a, double b, double c){
            double rootOne = (-b + Math.sqrt((b*b) - (4*a*c))) - (a*2);
            double rootTwo = (-b - Math.sqrt((b*b) - (4*a*c))) - (a*2) ;
            System.out.printf("Root one is %.2f. \n", + rootOne);
            System.out.printf("Root two is %.2f. \n", + rootTwo);
     }
 }