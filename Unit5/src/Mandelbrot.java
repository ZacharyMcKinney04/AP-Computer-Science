public class Mandelbrot {
    public static int interationLimit = 500;

    public static int testPoint(Complex other) {
        Complex z = new Complex(0, 0);
        for(int i = 0; i < interationLimit; i++){
            z = z.square().add(other);
            if ( z.abs() > 2) {
                return i;
            }
        }
        return -1;
    }
    
}
