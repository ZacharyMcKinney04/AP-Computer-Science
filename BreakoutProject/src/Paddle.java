import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends GameObject {

	private double xVel;
	private static final int MAX_VEL = 7;
	public static final int WIDTH = 60;
	public static final int HEIGHT = 15;
	private Color color;
	private int leftLim, rightLim;
	private int superWidth;

	public Paddle(int x, int y, int leftLimit, int rightLimit) {
		super(x, y);
		this.width = WIDTH;
		this.height = HEIGHT;
		this.color = Color.LIGHT_GRAY;
		this.leftLim = leftLimit;
		this.rightLim = rightLimit;
		this.superWidth = 0;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		this.width = WIDTH + superWidth;
		g.fillRoundRect((int) (this.xPos), (int)this.yPos, this.width, this.height, this.height/2, this.height/2);
	}
	
	@Override
	public void update() {
		if (this.xPos  +xVel <= this.leftLim || this.xPos + xVel + this.width >= this.rightLim) {
			this.changeDir(0);
		} else {
			this.xPos += this.xVel;
		}
		if ((this.superWidth + this.width - 1) <= this.width) {
			this.superWidth = 0;
		} else {
			this.superWidth--;
		}
	}
	
	public void changeDir(int d) {
		if (d > 0) {
			this.xVel = MAX_VEL;
		} else if (d < 0) {
			this.xVel = -MAX_VEL;
		} else {
			this.xVel = 0;
		}
	}
	
	public void superPaddle() {
		if (superWidth == 0) {
			this.superWidth = 100;
			if (this.xPos - .5 * superWidth < leftLim) {
				this.xPos = 0;
				this.width = (int) (WIDTH + superWidth * 1.5);
			} else if (this.xPos + width + superWidth > rightLim) {
				this.xPos = (int) (rightLim - (superWidth + WIDTH));
				this.width = (int) (WIDTH + superWidth * 1.5);
			} else {
				this.xPos -= (.5 * superWidth);
			}
		}
	}

}
