public class LetterFrequency {

    static double[] english = { 8.12, 1.49, 2.71, 4.32, 12.02, 2.3, 2.03, 5.92, 7.31, 0.1, 0.69, 3.98, 2.61, 6.95, 7.68,
            1.82, 0.11, 6.02, 6.28, 9.1, 2.88, 1.11, 2.09, 0.17, 2.11, 0.07 };

    static double[] spanish = { 12.16, 1.49, 3.87, 4.67, 14.08, 0.69, 1.00, 1.18, 5.98, 0.52, 0.11, 5.24,
            3.08, 7.00, 9.2, 2.89, 1.11, 6.41, 7.2, 4.60, 4.69, 1.05, 0.04, 0.14, 1.09, 0.47 };

    public static void main(String[] args) {
        // chose two strings - one in each language
        String englishStr = "The quickest brownest fox jumps over the lazy dog who is angry and mad.";
        String spanishStr = "El zorro marrón más rápido salta sobre el perro perezoso que está enojado y enojado.";
        System.out.print("For the English string it's determined to be ");
        determineLang(englishStr);
        System.out.print("For the Spanish string it's determined to be ");
        determineLang(spanishStr);
        // System.out.println(spanish.length);
    }
    
    public static void determineLang(String str){
        // calculate letter frequency for each
        double[] strFreq = letterFreq(str);
        // calculate loss function for each string in each language
        double engLoss = loss(strFreq, english);
        double spaLoss = loss(strFreq, spanish);
        // print out which language each string is likely to be
        if(engLoss > spaLoss){
            System.out.println("Spanish. ");
        } else{
            System.out.println("English. ");
        }
    }

    /**
     * Calculates the frequency of occurrence of each letter in a string.
     * expressed as a percentage between 0 and 100.
     * 
     * @param str the string to process
     * @return a double array of 26 elements with the frequency percentage of each
     *         letter from a to z
     */
    public static double[] letterFreq(String str) {
        str.toLowerCase();
        double[] hist = new double[26];
        int totalLetters = 0;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (index >= 0 && index <= 25) {
                hist[index]++;
                totalLetters++;
            }
        }
        for (int i = 0; i < hist.length; i++){
            hist[i] = (hist[i] / totalLetters) * 100;
        }
        return hist;
    }

    /**
     * Calculate the squared error function for two arrays.
     * The two arrays must be the same length.
     * Sqaure error = sum of (value - reference)^2 for each element
     * 
     * @param values    the array of values to be tested
     * @param reference the reference or target value for each element
     * @return the squared error between each element of the array
     */
    public static double loss(double[] values, double[] reference) {
        int sum = 0;
        for(int i = 0; i < values.length; i++){
            double difference = values[i] - reference[i];
            sum += (difference*difference); 
        }
        return sum;
    }

}
