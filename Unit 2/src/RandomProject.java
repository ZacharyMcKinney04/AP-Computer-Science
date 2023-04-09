public class RandomProject{
    public static void main(String[] args){
        for(int repeat = 10; repeat >= 0; repeat--){
            System.out.println(getLcgNum(10));
       }
    }

    public static int getLcgNum(int range){
        int a = 907;
        int c = 11;
        double intSysTime = (System.nanoTime()/(Math.pow(10.0, 1)))%7.0; 
        System.out.println(intSysTime);
        return ((int) ( a * intSysTime + c ) % range);
    }

}