import java.awt.Graphics;

public interface Animatable {

	/**
	 * This method should paint the object on the Graphics screen
	 * 
	 * @param g the Graphics object to be painted on
	 */
	public void paint(Graphics g);
	
	/**
	 * This method should update the object's state with whatever
	 * changes should occur in the current frame "tick". 
	 */
	public void update();

}
