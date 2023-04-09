import java.util.Scanner;
@SuppressWarnings("resource")

public class Echo {
    public static void main(String[] args) {
        int age;
        String name;
        Scanner in = new Scanner(System.in); 

        //name input
        System.out.print("Name: \u20AC");
        name = in.nextLine();
        System.out.println("Hi, €" + name);

        //age output
        System.out.print("Age: ");
        age = in.nextInt();
        int birthDay = 2022 - age; //initialized integer
        System.out.println("You were born in: " + birthDay);
    }

    
}
