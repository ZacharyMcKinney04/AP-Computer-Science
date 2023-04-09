/**
 * A rational number is a number that can be expressed as the
 * quotient or fraction. This class will allow basic operations
 * involving them including simpliy, add, subtract, multiply.
 * Includes toString, toDouble, negate, invert methods, and
 * greatest common divisor methods.
 * 
 * @author Zachary McKinney
 * @version 1.0
 */

public class Rational {
    /**
     * The numerator or top number of this {@code Rational}.
     * Will default to 0. If negative, will attach to negative sign.
     */
    private int numerator;

    /**
     * The denominator or bottom number of this {@code Rational}.
     * Will default to 1.
     */
    private int denominator;

    /**
     * Constructs and initializes a default no argument Rational
     * object with the numerator 0 and denominator 1.
     */
    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * Constructs and initializes a Rational with a single number as input
     * with denominator set to 1
     * 
     * @param numerator the numerator of the newly constructed {@code Rational}
     */
    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /**
     * Constructs and initializes a Rational with two
     * specified parameters {@code (numerator,denominator)}
     * 
     * @param numerator   the numerator of the newly constructed {@code Rational}
     * @param denominator the denominator of the newly constructed {@code Rational}
     */
    public Rational(int numerator, int denominator) {
        if (denominator != 0) {
            int gcd = getGCD(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        } else {
            throw new IllegalArgumentException("Denominator can't equal zero");
        }
    }

    // Behaviors
    /**
     * Private helper method that help converts the Rational
     * object to a fraction in lowest terms using GCD algorithm
     * 
     * @param numerator
     * @param denominator
     * @return int of greatest common divisor or factor
     */
    private int getGCD(int numerator, int denominator) {
        int result = 1;
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        while (result != 0) {
            if (numerator > denominator) {
                result = numerator % denominator;
                if (result == 0) {
                    return denominator;
                }
                numerator = result;
            } else if (denominator > numerator) {
                result = denominator % numerator;
                if (result == 0) {
                    return numerator;
                }
                denominator = result;
            }
        }
        return 1;
    }

    /**
     * Returns a double-precision approximation of the value
     * of Rational object
     * 
     * @return the double value of num / denom
     */
    public double toDouble() {
        return (double) this.numerator / this.denominator;
    }

    /**
     * Returns a string of the Rational object
     * as a fraction that allows it be printed
     * 
     * @return the String of num / denom
     */
    public String toString() {
        return String.format("%d/%d", this.numerator, this.denominator);
    }

    /**
     * Returns a new Rational object that is negative
     * 
     * @return -1 * Rational
     */
    public Rational negate() {
        return new Rational(this.numerator * -1, this.denominator);
    }

    /**
     * Returns a new Rational object that is the inverse.
     * The numerator and denominator switch places
     * 
     * @return new Rational of this denominator / numerator
     */
    public Rational invert() {
        return new Rational(this.denominator, this.numerator);
    }

    /**
     * Adds two Rational objects togther and returns
     * a new Rational object in lowest terms
     * 
     * @param r2 second Rational added to this Rational
     * @return Rational of r1 + r2
     */
    public Rational add(Rational r2) {
        int commonDenom = this.denominator * r2.denominator;
        int sum = (this.numerator * r2.denominator) +
                (r2.numerator * this.denominator);
        return new Rational(sum, commonDenom);
    }

    /**
     * Subtracts two Rational objects and returns
     * a new Rational object in lowest terms
     * 
     * @param r2 Rational object that is subtracted from r1
     * @return new Rational of r1 - r2
     */
    public Rational subtract(Rational r2) {
        int commonDenom = this.denominator * r2.denominator;
        int difference = (this.numerator * r2.denominator) - (r2.numerator * this.denominator);
        return new Rational(difference, commonDenom);
    }

    /**
     * Multiply two rationals together and return new
     * Rational object in lowest terms
     * 
     * @param r2 Rational multiplying this Rational
     * @return new Rational of r1 * r2
     */
    public Rational multiply(Rational r2) {
        return new Rational(this.numerator * r2.numerator, this.denominator * r2.denominator);
    }

    /**
     * Divide two rationals and return new
     * Rational object in lowest terms
     * 
     * @param r2 object dividing this Rational object
     * @return new Rational of r1 / r2
     */
    public Rational divide(Rational r2) {
        return multiply(r2.invert());
    }

}
