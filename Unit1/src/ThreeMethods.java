public class ThreeMethods {
    public static void main(String[] args) throws Exception {
        int seconds = 98883;
        int diameter = 12;
        int height = 12;
        String time = calcTime(seconds);
        double a = 3;
        double b = 7;
        double c = -5;
        System.out.print(time);
        calcRoots(a, b, c);
        double cyclinderVolume = calcCylinderVolume(diameter, height);
        System.out.printf("%.2f centimeters cubed. \n", cyclinderVolume);
        System.out.println();
    }

    //calculate time
    public static String calcTime(int seconds){
        final int SECONDS_IN_HOUR = 3600;
        final int SECONDS_IN_MINUTE = 60;
        int hour = seconds / SECONDS_IN_HOUR;
        int minutes = (seconds % SECONDS_IN_HOUR)/SECONDS_IN_MINUTE;
        int secondsLeft = (seconds % SECONDS_IN_HOUR)%SECONDS_IN_MINUTE;
        String time = String.format("The time is %02d:%02d:%02d \n", hour, minutes, secondsLeft); 
        return time;
    }

    //calculate roots
    public static void calcRoots(double a, double b, double c){
        double rootOne = (-b + Math.sqrt(b*2-(4*a*c))) / (2*a);
        double rootTwo = (-b - Math.sqrt(b*2-(4*a*c))) / (2*a);
        System.out.printf("The two roots are %.2f and %.2f. \n", rootOne, rootTwo);
    }

     //calculate cylinder
    public static double calcCylinderVolume(int diameter, int height){
        double volume = Math.PI *(diameter/2)* (diameter/2) * height;
        return volume;
    }
}
    