public class ElegantArrays {

    public static void main(String[] args) {
        // A couple of tests
        boolean[] tempArrBoolean = { true, false, true, false, false, true, false, true, true, true };
        double[] tempArrDouble = {8,9, 8, 3, 6, 7, 0, 8, 1, 8};
        int[] tempArrInt = { 9, 9, 8, 2, 7, 0, 2, 5, 3, 0, 8, 9, 8, 4, 2, 1, 5, 9, 5, 1, 8, 1, 5, 0, 6 };
        System.out.println(majority(tempArrBoolean));
        for (double value : minMeanMax(tempArrDouble)) {
            System.out.println(value);
        }
        System.out.println(mode(tempArrInt));
    }

    // takes the votes and returns int how much majority won
    public static int majority(boolean[] votesArr) {
        int trueCount = 0;
        int falseCount = 0;
        for (boolean vote : votesArr) {
            // vote is boolean. If true then true++
            if (vote) {
                trueCount++;
            } else {
                falseCount++;
            }
        }
        return trueCount - falseCount;
    }

    // returns min, mean, and then max of values
    public static double[] minMeanMax(double[] values) {
        double min = values[0];
        double max = values[0];
        double sum = values[0];
        int length = values.length; // doesn't have to find length every time 
        for (int index = 1; index < length; index++) {
            sum += values[index];
            if (values[index] < min) {
                min = values[index];
            } else if (values[index] > max) {
                max = values[index];
            }
        }
        double[] arrReturn = { min, sum / length, max };
        return arrReturn;

    }

    // returns int, the mode, of numbers
    public static int mode(int[] numbers) {
        // this part sorts into array
        int[] arrCount = new int[10];
        int length = 10;
        for (int number : numbers) {
            arrCount[number]++;
        }
        // this part finds mode and returns it
        int modeAmount = arrCount[0];
        int modeIndex = 0;
        for (int index = 1; index < length; index++) {
            if (arrCount[index] > modeAmount) {
                modeIndex = index;
                modeAmount = arrCount[index];
            }
        }
        return modeIndex;
    }
}