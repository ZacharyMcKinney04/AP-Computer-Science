import java.util.Arrays;

public class ArrayExercises {

    public static void main(String[] args){
        String testString1 = "stop";
        String testString2 = "pots";
        System.out.println(Arrays.toString(letterHist(testString1)));
        System.out.println();
        System.out.println(isAnagram(testString1, testString2));
    }

    // exercise 7.7
    // I was kind of confused on what you asked for in google classroom for 7.7
    public static int[] letterHist(String s){
        s.toLowerCase();
        int[] letterCount = new int[27];
        for(int index = 0; index < s.length(); index++ ){
            int elementPlace = ((int) s.charAt(index)) - 97;
            letterCount[elementPlace]++ ;
        }
        return letterCount;

    } 
    
    // exercise 6.6
    public static boolean canSpell(String s1, String s2){
        //create a histogram of s1 and s2
        //create a for loop that goes through the histogram 27 times or the length of a histogram
        // compare the values with an if statement
        // if the letters of the word you want to spell is not less than or equal to the 
        // letters you have then it'll return false
        // else it will return true

        return false; // return to remoe error messages
    }

    //execise 7.8
    public  static boolean isAnagram(String s1, String s2){
        int arr1[] = letterHist(s1); // ok to alias because I dont need to copy it
        System.out.println(Arrays.toString(arr1));
        int arr2[] = letterHist(s2);
        System.out.println(Arrays.toString(arr2));
        for(int i = 0; i < arr1.length; i++ ){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
