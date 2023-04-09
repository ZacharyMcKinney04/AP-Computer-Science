public class LoopExercise{
    public static void main(String[] args){
        for (int number = 999900000; number <= 1000000000; number++){
           if (isPrime(number)){
            System.out.println(number);
           }
        }
    }

    public static boolean isPrime(int n){
        int limit = (int)Math.sqrt(n);
        for (int k = 2; k <= limit; k++){
            if ( n% k == 0){
                return false;
            }
        }
        return true;
    }
}