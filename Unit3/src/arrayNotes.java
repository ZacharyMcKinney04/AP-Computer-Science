import java.util.Arrays;

public class arrayNotes {
    public static void main(String[] args){
        // int x = 9;
        // String string = "THis is a badly named string";
        int[] y = new int[5] ;
        String[] strings = new String[3];


        y[0] = 1;
        y[1] = 3;
        y[2] = 5;
        y[3] = 7;
        y[4] = 9;
        // int[] z = {100, 200, 300, 400, 500}; // shortcut to initialization
        // char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        strings[0] = "Hello";
        strings[1] = strings[0] + "good afternoon";
        strings[2] = "nullified the null";

        // System.out.println(strings[0] + strings[1] + strings[2]);
        for (int i = 0; i < strings.length; i++){
            System.out.println(y[i]);
            System.out.println(strings[i]);

        }

        int sum = 0;
        for(int i = 0; i < y.length; i++){
            sum += y[i];
        }
        double average = (double) sum / y.length;
        System.out.println(average);

        int total = 0;
        for(int value : y){ // enhanced FOR loop traverses array
            total += value; 
            System.out.println(total);
        }

        System.out.println(Arrays.toString(y));
        for(int i : y){ // for:each loops are read only
            i *= 2; // i is a primative copy right now
                    // no idea what the index is
            System.out.println(i);

        }
        System.out.println(Arrays.toString(y));

        for(String s : strings){
            // for each string s in strings, do something
            System.out.println(s);
        }
    }
    
}
