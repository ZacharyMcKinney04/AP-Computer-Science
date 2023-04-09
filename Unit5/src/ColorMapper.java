import java.awt.Color;

public class ColorMapper {
    
    public static int colorScheme = 6;
    
    static Color mapColor(int n) {
        if (colorScheme == 1) {
            return scheme1(n);
        } else if (colorScheme == 2) {
            return scheme2(n);
        } else if (colorScheme == 3) {
            return scheme3(n);
        } else if (colorScheme == 4) {
            return scheme4(n);
        } else if (colorScheme == 5) {
            return scheme5(n);
        } else if (colorScheme == 6) {
            return scheme5(n);
        } else {
            throw new RuntimeException("Invalid color scheme ");

        }
    }
    
    public static Color scheme1(int n) {
        int iterationLimit = Mandelbrot.interationLimit;
        if (n == -1) {
            return Color.black; 
        }
        double nProp = (double) n / iterationLimit;
        int red = (int) (255 / 2 * (Math.sin(15*nProp)+1));
        int blue = (int) (255 / 2 * (Math.sin(5 * nProp)+1));
        int green = (int) (255 / 2 * (Math.sin(8*nProp)+1));
        return new Color(red, green, blue);
    }
    
    public static Color scheme2(int n) {
        int iterationLimit = Mandelbrot.interationLimit;
        if (n == -1) {
            return Color.black;
        }
        double nProp = (double) n / iterationLimit;
        int blue = (int) (255 / 2 * (Math.sin(17.3*nProp)+1));
        int green = (int) (255 / 2 * (Math.sin(11 * nProp)+1));
        int red = (int) (255 / 2 * (Math.sin(4.7*nProp)+1));
        return new Color(red, green, blue);
    }
    
    public static Color scheme3(int n) {
    int iterationLimit = Mandelbrot.interationLimit;
        if (n == -1) {
            return Color.black;
        }
        double nProp = (double) n / iterationLimit;
        int red = (int) (255 / 2 * (Math.cos(6.3 * nProp)+1));
        int green = (int) (255 / 2 * (Math.cos(12.5 * nProp)+1));
        int blue = (int) (255 / 2 * (Math.cos(18.39*nProp)+1));
        return new Color(red, green, blue);
    }

    public static Color scheme4(int n) {
    int iterationLimit = Mandelbrot.interationLimit;
        if (n == -1) {
            return Color.black;
        }
        double nProp = (double) n / iterationLimit;
        int red = (int) (255 / 2 * (Math.cos(9.4 * nProp)+1));
        int green = (int) (255 / 2 * (Math.cos(15.6 * nProp)+1));
        int blue = (int) (255 / 2 * (Math.cos(22*nProp)+1));
        return new Color(red, green, blue);
    }

    public static Color scheme5(int n) {
    int iterationLimit = Mandelbrot.interationLimit;
        if (n == -1) {
            return Color.black;
        }
        double nProp = (double) n / iterationLimit;
        int red = (int) (255 / 2 * (-1 * Math.cos(28 * nProp)+1));
        int green = (int) (255 / 2 * (-1 * Math.cos(9.4 * nProp)+1));
        int blue = (int) (255 / 2 * (-1 * Math.cos(15.7 * nProp)+1));
        return new Color(red, green, blue);
    }
    public static Color scheme6(int n) {
    int iterationLimit = Mandelbrot.interationLimit;
        if (n == -1) {
            return Color.black;
        }
        double nProp = (double) n / iterationLimit;
        int red = (int) (255 / 2 * (-1 * Math.cos(28 * nProp)+1));
        int blue = (int) (255 / 2 * (-1 * Math.cos(9.4 * nProp)+1));
        int green = (int) (255 / 2 * (-1 * Math.cos(15.7 * nProp)+1));
        return new Color(red, green, blue);
    }

}