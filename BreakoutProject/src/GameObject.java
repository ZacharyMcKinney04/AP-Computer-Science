import java.awt.Graphics;

public abstract class GameObject implements Animatable{
	
	protected double xPos, yPos;
	protected int width, height;				
		
	public GameObject(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		this.width = 0;
		this.height = 0;
	}
	
	public abstract void paint(Graphics g);
	
	public abstract void update();
	
}
