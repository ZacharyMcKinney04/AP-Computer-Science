import java.awt.Point;

public class MutableObjects {

    public static void main(String[] args) {
        Point origin = new Point(0,0);
        System.out.println(origin);
        origin.move(-5,-10);
        System.out.println(origin);
        System.out.println(origin.distance(0,0));
    }
    
}
