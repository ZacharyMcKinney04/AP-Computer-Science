import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FractalPanel extends JPanel implements MouseListener, KeyListener {
    private int height = 400;
    private int width = 600;
    private View v;
    private View[] vArr = new View[1];
    private Complex topLeft = new Complex (-2, 1);
    private Complex bottomRight = new Complex (1, -1);
    private double movement = .1;
    private final int MAX_ITERATION = 1000;
    private final int MIN_ITERATION = 25;
    private int iterationChange = 25;
    
    public FractalPanel() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        v = new View(width, height);
        vArr[0] = new View(v.screenWidth, v.screenHeight); 
        addMouseListener(this);
        addKeyListener(this);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Complex c = v.translate(col, row);
                int iterationNumber = Mandelbrot.testPoint(c);
                Color map = ColorMapper.mapColor(iterationNumber);
                g.setColor(map);
                g.fillRect(col, row, 1, 1);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        topLeft = v.translate(mouseX, mouseY);
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        bottomRight = v.translate(mouseX, mouseY);
        v.setComplexCorners(topLeft, bottomRight);
        View[] vArrTemp2 = new View[vArr.length + 1];
        for(int i = 0; i < vArr.length; i++) {
            vArrTemp2[i] = vArr[i];
        }
        vArrTemp2[vArr.length] = v;
        vArr = vArrTemp2;
        repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // unused
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        // unused
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        // unused
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '1') {
            System.out.println("Scheme 1");
            ColorMapper.colorScheme = 1;
            repaint();
        }
        if (e.getKeyChar() == '2') {
            System.out.println("Scheme 2");
            ColorMapper.colorScheme = 2;
            repaint();
        }
        if (e.getKeyChar() == '3') {
            System.out.println("Scheme 3");
            ColorMapper.colorScheme = 3;
            repaint();
        }
        if (e.getKeyChar() == '4') {
            System.out.println("Scheme 4");
            ColorMapper.colorScheme = 4;
            repaint();
        }
        if (e.getKeyChar() == '5') {
            System.out.println("Scheme 5");
            ColorMapper.colorScheme = 5;
            repaint();
        }
        if (e.getKeyChar() == '6') {
            System.out.println("Scheme 6");
            ColorMapper.colorScheme = 5;
            repaint();
        }
        if (e.getKeyChar() == 'z') {
            if ( vArr.length == 1) {
                System.out.println("Can't undo anymore ");
            } else {
                View[] vArrTemp = new View[vArr.length - 1];
                for(int i = 0; i < vArrTemp.length; i++) {
                    vArrTemp[i] = vArr[i];
                }
                vArr = vArrTemp;
                v = vArr[vArr.length - 1];
                repaint();
            }
        }
        if (e.getKeyChar() == 'a' ) {
            double a = topLeft.getA();
            double b = bottomRight.getA();
            double move = Math.abs((b - a) * movement); 
            double diff = a - Math.abs(b);
            a = a - move;
            if (a < -2) {
                a = -2;
                b = a + diff;
            } else {
                b = b - move;
            }
            topLeft = new Complex(a, topLeft.getB());
            bottomRight = new Complex(b, bottomRight.getB());
            v.setComplexCorners(topLeft, bottomRight);
            repaint();
        }
        if (e.getKeyChar() == 's') {
            double a = topLeft.getB();
            double b = bottomRight.getB();
            double move = Math.abs((a - b) * movement); 
            double diff = a - Math.abs(b);
            b = b - move;
            if (b < -1) {
                b = -1;
                a = b + diff;
            } else {
                a = a - move;
            }
            topLeft = new Complex(topLeft.getA(), a);
            bottomRight = new Complex(bottomRight.getA(), b);
            v.setComplexCorners(topLeft, bottomRight);
            repaint();
        }
        if (e.getKeyChar() == 'w' ) {
            double a = topLeft.getB();
            double b = bottomRight.getB();
            double move = Math.abs((a - b) * movement); 
            double diff = a - Math.abs(b);
            a = a + move;
            if (a > 1) {
                a = 1;
                b = a - diff;
            } else {
                b = b + move;
            }
            topLeft = new Complex(topLeft.getA(), a);
            bottomRight = new Complex(bottomRight.getA(), b);
            v.setComplexCorners(topLeft, bottomRight);
            repaint();
        }
        if (e.getKeyChar() == 'd' ) {
            double a = topLeft.getA();
            double b = bottomRight.getA();
            double move = Math.abs((b - a) * movement); 
            double diff = a - Math.abs(b);
            b = b + move;
            if (b > 1) {
                b = 1;
                a = b - diff;
            } else {
                a = a + move;
            }
            topLeft = new Complex(a, topLeft.getB());
            bottomRight = new Complex(b, bottomRight.getB());
            v.setComplexCorners(topLeft, bottomRight);
            repaint();
        }
        if (e.getKeyChar() == '=') {
            if (Mandelbrot.interationLimit + iterationChange > MAX_ITERATION) {
                Mandelbrot.interationLimit = MAX_ITERATION;
                System.out.println("Max iteration limit hit - 1000");
            } else {
                Mandelbrot.interationLimit += iterationChange;
                System.out.println("Iterations " + Mandelbrot.interationLimit);
            }
        }
        
        if (e.getKeyChar() == '-') {
            if (Mandelbrot.interationLimit - iterationChange < MIN_ITERATION) {
                Mandelbrot.interationLimit = iterationChange;
                System.out.println("Lowest iteration limit hit - " + iterationChange);
            } else {
                Mandelbrot.interationLimit -= iterationChange;
                System.out.println("Iterations " + Mandelbrot.interationLimit);
            }
        }
        if (e.getKeyChar() == 'o') {
            double a = topLeft.getA();
            double b = bottomRight.getA();
            double move = Math.abs((b - a) * movement); 
            topLeft = new Complex(a - move, topLeft.getB());
            bottomRight = new Complex(b + move, bottomRight.getB());
            v.setComplexCorners(topLeft, bottomRight);
            repaint();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        //unused
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        //unused
    }

}