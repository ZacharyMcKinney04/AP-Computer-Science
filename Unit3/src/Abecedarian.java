public class Abecedarian {
    public static void main(String[] args) {
        System.out.println(isAbecedarian("Racecar"));
        System.out.println(isAbecedarian("abdest"));
        System.out.println(isAbecedarian("acknow"));
        System.out.println(isAbecedarian("dimpsy"));
        System.out.println(isAbecedarian("cba"));
    }

    public static boolean isAbecedarian(String inputString) {
        String lowerCaseInput = inputString.toLowerCase();
        // -1 means stop before using the last character
        // +1 means the next character
        for(int charIndex = 0; charIndex < (inputString.length() - 1); charIndex++){
            if(lowerCaseInput.charAt(charIndex) >= lowerCaseInput.charAt(charIndex + 1)){
                return false;
            }
        }
        return true;
    }
}
