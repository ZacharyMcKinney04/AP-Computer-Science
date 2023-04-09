import java.math.BigInteger;

public class ImmutableObjects {

    public static void main(String[] args) {
        // String s0 = "Hello World";
        // String s1 = "This is a recap";
        // String s2 = "chapter 9 is about immutable objects";
        // String s3 = "We got an assignemtn that's due tomorrow";
        
        // Integer mushrooms = Integer.valueOf("123");
        // Double d = Double.parseDouble("3.14159");
        System.out.println(Integer.MAX_VALUE);
        BigInteger b = new BigInteger("123333333456765456765567656776567876567656787656787666787654567654567");
        BigInteger b2 = new BigInteger("12333333456765456765567656776567876567656787656787666787654567654567");
        b = b.add(b2);
        System.out.println(b);

    }
}
