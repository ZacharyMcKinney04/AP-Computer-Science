/**
 * A complex numbers are numbers that express the form
 * a + bi where a and b are real numbers and i is
 * an imaginary number called "iota"
 * This class allows adding, subtracting, multiplying
 * and dividing complex numbers. Has an equals, square,
 * absolute value, toString, and getter methods.
 * 
 * @author Zachary McKinney
 * @version 1.0
 */
public class Complex {
    private double real;
    private double imaginary;

    public Complex() {
        this.real = 0;
        this.imaginary = 0;
        // this.notReal = 1;
    }

    public Complex(double a) {
        this.real = a;
        this.imaginary = 0;
        // this.notReal = 1;
    }

    public Complex(double a, double b) {
        this.real = a;
        this.imaginary = b;
        // this.notReal = 1;
    }

    public boolean equals(Complex other) {
        return this.toString().equals(other.toString());
    }

    public boolean equals(double other) {
       String otherS = new Complex(other).toString(); 
       return this.toString().equals(otherS);
    }

    public Complex square() {
        return this.multiply(this);

    }

    public double abs() {
        return Math.hypot(this.real, this.imaginary);
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real,
                this.imaginary + other.imaginary);
    }

    public Complex add(double realA2) {
        return new Complex(this.real + realA2, this.imaginary);

    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real,
                this.imaginary - other.imaginary);

    }

    public Complex subtract(double real2) {
        return new Complex(this.real - real2, this.imaginary);

    }

    /**
     * uses f o i l to multiply two complexes
     */
    public Complex multiply(Complex other) {
        double f = this.real * other.real;
        double oi = this.real * other.imaginary + this.imaginary * other.real;
        double l = -1 * (this.imaginary * other.imaginary);
        return new Complex(f + l, oi);
    }
    
    public Complex multiply(double real2) {
        return new Complex(this.real * real2, this.imaginary * real2);

    }

    public Complex divide(Complex other) {
        Complex conjugate = new Complex(other.real, other.imaginary * -1);
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        Complex numerator = this.multiply(conjugate);
        return new Complex(numerator.real / denominator, numerator.imaginary / denominator);
    }
    
    public Complex divide(double real2) {
        return new Complex(this.real / real2, this.imaginary / real2);
    }

    public String toString() {
        return String.format("%.3f + %.3fi", this.real, this.imaginary);
    }

    public double getA() {
        return this.real;
    }

    public double getB() {
        return this.imaginary;
    }

}
