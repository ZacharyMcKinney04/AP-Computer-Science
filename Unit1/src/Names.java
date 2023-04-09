public class Names {
    public static void main(String[] args){
        greet("Onishi","Sapporo");
        greet("Tom","New York");
        greet("Stephanie","Manila");
        greet("Wolfgang","Prague");

    }


    public static void greet(String name, String hometown){
        System.out.println("Hello, " + name + "-san from " + hometown);
        System.out.println("Welcome to Normal, Illinois. ");
        System.out.println("It's a long way from " + hometown + "!");
        System.out.println();
    }

}