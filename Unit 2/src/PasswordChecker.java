public class PasswordChecker {
    public static void main(String[] args) {
        checkPassword("aB09____"); // put in password here
    }

    public static boolean checkPassword(String inputPassword) {
        // requirements
        final int MIN_LENGTH = 8;
        final int MIN_LOWCASE = 1;
        final int MIN_UPCASE = 1;
        final int MIN_NUMBER = 2;
        final int MIN_SPEC_CHAR = 0;

        // setting variables for the new password
        int lowcase = 0;
        int upcase = 0;
        int number = 0;
        int specChar = 0;

        for (int charIndex = 0; charIndex < inputPassword.length(); charIndex++) {

            // have to reset booleans after each time charInt is set
            int charInt = (int) inputPassword.charAt(charIndex);
            boolean lowerCaseRange = charInt >= 'a' && charInt <= 'z';
            boolean specCharRange1 = charInt >= 33 && charInt <= 47;
            boolean specCharRange2 = charInt >= 58 && charInt <= 64;
            boolean specCharRange3 = charInt >= 91 && charInt <= 96;
            boolean specCharRange4 = charInt >= 123 && charInt <= 126;
            boolean upcaseRange = charInt >= 'A' && charInt <= 'Z';
            boolean numberRange = charInt >= '0' && charInt <= '9';

            //if else statements sorting each characters
            if (lowerCaseRange) { // lower case
                lowcase++;
            } else if (upcaseRange) { // uppercase
                upcase++;
            } else if (numberRange) { // number
                number++;
            } else if (specCharRange1 || specCharRange2 || specCharRange3 || specCharRange4) {
                specChar++;
            } else {
                System.out.println("Invalid character at spot " + (charIndex + 1));
            }
        }

        // check after each character has been sorted. 2 if statements 2 make shorter line
        if (MIN_LENGTH > inputPassword.length() || MIN_UPCASE > upcase || MIN_LOWCASE > lowcase) {
            System.out.println("Please meet the requirements. ");
            return false;
        } else if (MIN_SPEC_CHAR <= specChar && MIN_NUMBER <= number) {
            System.out.println("Minimum requirements met ");
            return true;
        }
        return false;
    }
}
