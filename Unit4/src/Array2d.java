public class Array2d {
    public static void main(String[] args){
        String[][] strArr = createArr(5, 5);
        printArr(strArr);
    }

    public static String[][] createArr(int rSize, int cSize){
        String[][] strArr = new String[rSize][cSize];
        for (int r = 0; r < strArr.length; r++){
            for (int c = 0; c < strArr[r].length; c++){
                strArr[r][c] = "Row " + r + ", Column " + c;
            }
        }
        return strArr;
    }

    public static void printArr(String[][] strArr){
        for (int r = 0; r < strArr.length; r++) {
            for (int c = 0; c < strArr[r].length; c++){
                System.out.printf("%10s ", strArr[r][c]);
            } 
            System.out.println();
          }
    }
    
}
