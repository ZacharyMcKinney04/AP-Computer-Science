public class TestingGround {
    public static void main(String[] args) {
        // String s = "1234567890Hello!";
        // char c = 'A';
        // String output = "";
        // for (int i = 0; i < s.length(); i++){
        // c = s.charAt(i);
        // c -=32;
        // output += c;
        // }
        // System.out.print(System.currentTimeMillis());
        for( int x = 0; x <= 10000; x++){
            int randomInt = (int) (Math.random() * 91) + 10;
            if (randomInt == 100){
                System.out.println(randomInt);
            }
        }
        // for (int k = 1; k <= 1000; k++) {
        //     if (k >= '0' && k <= '9'){
        //         System.out.print((char) k + "_");
        //         System.out.println(k);
        //     }

    // for (char c1 = 'a'; c1 <= 'z'; c1++){
    // for (char c2 = 'a'; c2 <= 'z'; c2++){
    // System.out.print(c1);
    // System.out.print(c2);
    // System.out.println();
    // }
    // }
    }

    public static void oddCount() {
        for (int k = 0; k <= 100; k += 5) {
            System.out.print(k + ", ");
            for (int j = 1; j <= 4; j++) {
                System.out.print((k + j) + ", ");
            }
            System.out.println();
        }

    }
}
