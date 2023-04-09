import java.awt.Color;
import java.awt.Graphics;

public class Wall extends GameObject {

	public Wall(int x, int y, int w, int h) {
		super(x, y);
		this.width = w;
		this.height = h;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int)this.xPos, (int)this.yPos, this.width, this.height);
	}

	@Override
	public void update() {
		// do nothing
	}
	
}
