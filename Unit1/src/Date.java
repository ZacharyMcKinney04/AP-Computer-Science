public class Date {
    public static void main(String[] args) throws Exception {
        printAmerican("Wednesday", "September", 7, 2022);
        printEuropean("Wednesday", "September", 7, 2022);
    }

    //americanprint
    public static void printAmerican(String day, String month, int date, int year){
        System.out.print("American Format: " + day + ", " + month);
        System.out.print(" " + date + ", " + year);
        System.out.println();
    }

    //europeanprint
    public static void printEuropean(String day, String month, int date, int year){
        System.out.print("European Format: " + day + " " + date);
        System.out.print(" " + month + " " + year);
        System.out.println();
    }
}
    