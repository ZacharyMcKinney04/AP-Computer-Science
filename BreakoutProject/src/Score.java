import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Score extends GameObject implements Animatable{

	private final static Font scoreFont = new Font("Dialog", Font.BOLD, 15);
	private int lives;
	private int points;

	public Score(int x, int y, int lives, int points) {
		super(x, y);
		this.lives = lives;
		this.points = points;

	}

	@Override
	public void paint(Graphics g) {
		String info = String.format("Points: %d Lives: %d", this.points, this.lives);
		g.setColor(Color.WHITE);
		g.setFont(scoreFont);
		g.drawString(info, (int) this.xPos, (int) this.yPos);
	}

	@Override
	public void update() {
		// do nothing
	}

	public void addLives(int lives) {
		this.lives += lives;
	}

	public void addPoints(int points) {
		this.points += points;
	}

	public int getLives() {
		return this.lives;
	}

}