public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
       char grade = grader(75);
       System.out.println(grade);
        // conditionalCheck1(3,2);
        // conditionalCheck1(2,2);
        // conditionalCheck1(0,-2);
    }

    public static void conditionalCheck1(int a, int b){
        System.out.println("A is " + a + " B is " + b);
        if ( a < b){
            System.out.println("a < b");
        } 
        if ( a > b){
            System.out.println("a > b");
        } 
        if ( a <= b){
            System.out.println("a <= b");
        } 
        if ( a > b){
            System.out.println("a >= b");
        } 
        if ( a == b){
            System.out.println("a == b");
        } 
        if ( a != b){
            System.out.println("a != b");
        } 
        
    }
   
    public static void conditionalCheck2(int a, int b){
        System.out.println("A is " + a + " B is " + b);
        if ( a < b){
            System.out.println("a < b");
        } else if ( a > b){
            System.out.println("a > b");
        } else {
            System.out.println("a == b");
        } 
        
    }

    public static char grader(int percent){
        char grade = ' '; // no grade provided
        if ( percent < 0 || percent > 100 ){
            grade = 'x';
        }
        if (percent > 100){
            grade = 'S'; // S means 100+ because it's a character
        } else if (percent >= 90 && percent < 100){
            grade = 'A';
        } else if (percent >= 80 && percent < 90){
            grade = 'B';
        } else if (percent >= 70 && percent < 80){
            grade = 'C';
        } else if (percent >= 60 && percent < 70){
            grade = 'D';
        } else if (percent >= 0 && percent < 60) {
            grade = 'F';
    }
    return grade;
    }
}
