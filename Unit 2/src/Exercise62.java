public class Exercise62 {
    public static void main(String[] args){
        double numberGiven = 50;
        System.out.printf("The square root of %.2f is %.2f ", numberGiven, squareRoot(numberGiven));
    }

    public static double squareRoot(double xValue){
        double estimateDifference = .0001;
        int firstTryBuffer = 1;
        double xNewValue = xValue/2; // This makes it so xprev will equal first guess of x/2
        double xPrevious = xValue + firstTryBuffer;
        while (Math.abs(xPrevious - xNewValue) > estimateDifference ){
            xPrevious = xNewValue;
            xNewValue = (xPrevious + ( xValue / xPrevious))/2 ;
        }
        return xNewValue;
    }
}
