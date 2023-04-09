public class IterativeExercises {
    public static void main(String[] args) {
        int receivingInteger = 5;
        System.out.println(factorialInt(receivingInteger));
        System.out.println(containThree(receivingInteger));
        System.out.println(fibonacciNumber(receivingInteger));
    }

    public static int factorialInt(int nValue) {
        int sumCurrent = 1;
        for (int subtractor = 0; subtractor != (nValue - 1); subtractor++) {
            int currentFactorial = (nValue - subtractor);
            sumCurrent = currentFactorial * sumCurrent;
        }
        return sumCurrent;
    }

    public static boolean containThree(int xValue){
        while(xValue > 0 ){
            if(xValue%10 == 3){
                return true;
            }
            xValue /= 10;
        }
        return false;
    }

    public static int fibonacciNumber(int n) {
        int term1;
        int term2 = 1;
        int sum = 0;
        if (n == 0) {
            return 0;
        } else {
            for (int xSequence = 1; xSequence != (n + 1); xSequence++) {
                term1 = term2;
                term2 = sum;
                sum = term1 + term2;
            }
            return sum;
        }
    }
}
