import java.awt.Color;
import java.awt.Graphics;

public class StrongBrick extends Brick{

    private int Strength;

    public StrongBrick(int x, int y) {
        super(x, y);
        this.Strength = 3;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(this.color);
        int x = (int) this.xPos;
		int y = (int) this.yPos;
		int w = this.width;
		// int h = this.height;
        g.fill3DRect(x, y, this.width - 2, this.height - 2, true);
        g.setColor(Color.BLACK);
        if (this.Strength < 3) {
            g.fill3DRect(x + w/8, y+1, x + w/8 + 10, y+5, true);
        }
        if (this.Strength < 2) {
            g.fill3DRect(x, y + 15,(int) (this.width - 2), this.height -35, true);
        }
    }

    public int getStrength() {
        return this.Strength;
    }

    public void setStrength(int strength) {
        this.Strength = strength;
    }

}
