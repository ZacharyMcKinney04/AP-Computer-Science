public class CodingBat {

    public static void main(String[] args){
        System.out.println(fibonacci(7));
        System.out.println(sumDigits(1023));
        int[] arr = {1, 4, 8};
        System.out.println(groupSum(0, arr, 10));

    }
    
    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        } else if (n == 1 || n== 2){
            return 1;
        } else {
            return fibonacci (n-1) + fibonacci(n-2);
        }
    }

    public static int sumDigits(int n){
        if(n < 10){
            return n;
        } else {
            return (int) n%10 + sumDigits ( n/10);
        }
    }

    public static boolean groupSum(int start, int[] arr, int target){
        if(start >= arr.length){
            return (target == 0);
        }
        if (groupSum(start+1, arr, target - arr[start])){
            return true;
        }
        if (groupSum(start + 1, arr, target)){
            return true;
        }
        return false;
    }
    //I had to use the solution for this method
}
