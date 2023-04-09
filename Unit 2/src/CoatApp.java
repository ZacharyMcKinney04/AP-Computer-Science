public class CoatApp {
    public static void main(String[] args) {
        int temp = 199;
        boolean isSnowing = true;
        boolean isRaining = true;
        boolean wearCoat = (temp < 50 || isSnowing || (isRaining && temp < 60));
        if (wearCoat) {
            System.out.println("Wear a coat.");
        } else {
            System.out.println("No coat needed.");
        }
    }
    
}                                                                                              