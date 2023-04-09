import java.math.BigInteger;

public class Big {

    public static void main(String[] args) {
        System.out.println(" N Answer");
        for(int i = 0; i < 31; i++){
            bigFactorial(i);
        }
    }
    // public static void factorial(int n) { 
    //     int sum = 1;
    //     for (int i = n; i > 1; i--) {
    //         sum *= i;
    //     }
    //     System.out.printf("%2d %d \n", n, sum);
    // }
    // @param n factorial number
    public static void bigFactorial(int n) { 
        BigInteger sum = new BigInteger("1");
        for (int i = n; i > 1; i--) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        System.out.printf("%2d %d \n", n, sum);
    }
}
