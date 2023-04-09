import java.util.Scanner;
@SuppressWarnings("resource")
public class ComparisonExercise{
    public static void main(String[] args){
       // fermat theorem program part
        System.out.println("Fermat Theorem Numbers ");
        int a = askInteger("a");
        int b = askInteger("b");
        int c = askInteger("c");
        int n = askInteger("n");
        isFermatTheorem( a, b, c, n);

        //triangle part of program
        System.out.println("Triangle lengths ");
        int d = askInteger("a");
        int e = askInteger("b");
        int f = askInteger("c");
        isTriangle(d, e, f);
    }
        
    public static int askInteger(String inputLetter){
        Scanner in = new Scanner(System.in);
        System.out.print("What is integer \"" + inputLetter + "\"? ");
        int outputNumber = in.nextInt();
        return outputNumber;
    }
    
    public static void isFermatTheorem(int a, int b, int c, int n){
        if (n > 2 && (Math.pow(a, n) + Math.pow(b, n) == Math.pow(c, n)) ){
            System.out.println("Holy smokes, Fermat was wrong!");
        } else{
            System.out.println("No, that doesn't work.");
        }
    }
    
    public static void isTriangle(int a, int b, int c){
        if( (a+b) < c || (b+c) <a || (c+a) < b){
            System.out.println("Can't Form a Triangle");
        }else{
            System.out.println("You can form a triangle");
        }
    }
}

