import java.awt.*;
import javax.swing.*;

public class RandomPanel extends JPanel {
    static final long serialVersionUID = 1;

    public RandomPanel() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawRandomWalk(g);
    }

    public void drawRandomWalk(Graphics g) {
        int yHeight = this.getHeight();
        int xLength = this.getWidth();
        int xValue = xLength / 2;
        int yValue = yHeight / 2;
        int xModifier = 10;
        int xModifierDiag = 7;
        int yModifier = 10;
        int yModifierDiag = 7;
        int yTemp = yValue;
        int xTemp = xValue;
        int lcgRange = 8;

        while (xTemp >= 0 && xTemp <= xLength && yTemp >= 0 && yTemp <= yHeight) {
            int lcgNumber = getLcgNum(lcgRange);
            xValue = xTemp;
            yValue = yTemp;
            System.out.println(lcgNumber);
            if (lcgNumber == 0) { // go up
                g.setColor(Color.GREEN);
                yTemp -= yModifier;
            } else if (lcgNumber == 1) { // right
                // g.setColor(Color.YELLOW);
                xTemp += xModifier;
            } else if (lcgNumber == 2) { // down
                // g.setColor(Color.ORANGE);
                yTemp += yModifier;
            } else if (lcgNumber == 3) { // left
                // g.setColor(Color.RED);
                xTemp -= xModifier;
            } else if (lcgNumber == 4) { // top left
                // g.setColor(Color.CYAN);
                xTemp -= xModifierDiag;
                yTemp -= yModifierDiag;
            } else if (lcgNumber == 5) { // top right
                // g.setColor(Color.PINK);
                xTemp += xModifierDiag;
                yTemp -= yModifierDiag;
            } else if (lcgNumber == 6) { // bottom right
                // g.setColor(Color.WHITE);
                xTemp += xModifierDiag;
                yTemp += yModifierDiag;
            } else { // bottom left
                // g.setColor(Color.MAGENTA);
                xTemp -= xModifierDiag;
                yTemp += yModifierDiag;
            }
            g.drawLine(xValue, yValue, xTemp, yTemp);
        }
    }

    public static int getLcgNum(int range) {
        final int A = 7;
        final int C = 1;
        double intSysTime = ((System.nanoTime() / 100)) % Math.pow(10, 5);
        System.out.println(intSysTime);
        System.out.println();
        return (int) Math.abs((A * intSysTime + C) % range);
    }
}