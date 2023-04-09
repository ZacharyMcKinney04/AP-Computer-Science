/**
 * View class
 * @version 1.0
 */
public class View {
    int screenWidth, screenHeight;
    double xSlope, xOffset, ySlope, yOffset;

    public View(int w, int h) {
        screenWidth = w;
        screenHeight = h;
        setComplexCorners(new Complex(-2, 1), new Complex(1, -1));
    }

    public Complex translate(int x, int y) {
        double real = this.xSlope * x + this.xOffset;
        double imag = this.ySlope * y + this.yOffset;
        return new Complex(real, imag);
    }

    public void setComplexCorners(Complex topLeft, Complex botRight) {
        xOffset =  topLeft.getA();
        yOffset = topLeft.getB();
        xSlope = (botRight.getA() - topLeft.getA()) / screenWidth;
        ySlope = -this.xSlope;
    }

}