public class LongestRun {

    public static void main(String[] args) {
        String[] stringArr = { "hello", "Can", "bee", "awesome", "a", "Sea", "a" };
        int[] testArr = { 1, 2, 5, 5, 5, 6, 2, 2, 2, 2, 0 };
        System.out.println(findLongestRun(testArr));
        System.out.println(duplicateString(stringArr));
        System.out.println(run(testArr));
    }

    public static boolean duplicateString(String[] arr) {
        for (int i = 0; i < arr.length; i++) { // i keeps track of current element to check
            String wordToCheck = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                String wordToCompare = arr[j];
                System.out.printf("Comparing %s to %s \n", wordToCheck, wordToCompare);
                if (wordToCheck.equals(wordToCompare)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int findLongestRun(int[] arr) {
        int count = 1;
        int longCount = 1;
        int longNumber = arr[0];
        int number = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == number) {
                count++;
                if (count > longCount) {
                    longNumber = arr[i];
                    longCount = count;
                }
            } else {
                count = 1;
                number = arr[i];
            }
        }
        return longNumber;
    }

    public static int run(int[] input) {
        int runstart = 0;
        int runlength = 1;
        int returnstart = 0;
        int returnlength = 1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == runstart) {
                runlength++;
            } else if (runlength > returnlength) {
                returnlength = runlength;
                returnstart = runstart;
                runlength = 1;
                runstart = i;
            }
        }
        return returnstart;
    }
}
