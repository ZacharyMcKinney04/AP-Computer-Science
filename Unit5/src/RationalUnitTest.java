/**
 * This is a unit test to make sure all the methods of the Rational class
 * are working fine and there's no bug with it.
 * @author Zachary McKinney
 * @version 1.0
 */
public class RationalUnitTest {

    public static void main(String[] args) {
        Rational r1 = new Rational();
        System.out.print("rational no arg () = 0 / 1 = ");
        System.out.println(r1.toString().equals("0/1"));

        r1 = new Rational(5);
        System.out.print("rational 1 arg (5) = 5/1 = ");
        System.out.println(r1.toString().equals("5/1"));

        r1 = new Rational(1, 4);
        System.out.print("rational 2 arg (1,4) = 1/4 = ");
        System.out.println(r1.toString().equals("1/4"));

        System.out.print("toDouble(1/4) = .25 = ");
        System.out.println(r1.toDouble() == .25);

        System.out.print("toString method(1,4) = 1/4 = ");
        System.out.println(r1.toString().equals("1/4"));
        System.out.print("toString method(1,4) != 1/2 = ");
        System.out.println(!(r1.toString().equals("1/2")));

        r1 = new Rational(2, 4);
        System.out.print("gcd(2,4) = 1/2 = ");
        System.out.println(r1.toString().equals("1/2"));

        r1 = new Rational(1, 4);
        System.out.print("negate(1,4) = -1/4 = ");
        System.out.println(r1.negate().toString().equals("-1/4"));

        Rational r2 = new Rational(2, 4);
        System.out.print("add 1/4 + 2/4 = 3/4 = ");
        System.out.println(r1.add(r2).toString().equals("3/4"));
        System.out.print("subtract 1/4 - 2/4 = -1/4 = ");
        System.out.println(r1.subtract(r2).toString().equals("-1/4"));
        
        System.out.print("multiply 1/4 * 2/4 = 1/8 = ");
        System.out.println(r1.multiply(r2).toString().equals("1/8"));
        
        System.out.print("divide 1/4 / 2/4 = 1/2 = ");
        System.out.println(r1.divide(r2).toString().equals("1/2"));


    }

}
