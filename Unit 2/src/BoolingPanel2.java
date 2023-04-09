import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;


public class BoolingPanel2 extends JPanel {

	/*
	 * Booling rules: Players have the same grid of random shapes and write code to
	 * create a pattern of boxes around the shapes. The object of the game is to
	 * solve your opponent's pattern, while creating a pattern that he or she cannot
	 * duplicate.
	 * 
	 * Each player is given a few minutes to write a boolean expression below that
	 * causes some of the shapes to be boxed in white. (For example, the expression
	 * ( s.isCircle ) would cause all circles to be boxed in white)
	 * 
	 * Once finished writing, players show each other the pattern on their screens,
	 * but not their code. They then try to duplicate their opponent's pattern with
	 * a boolean expression of their own. It is not necessary to write the exact
	 * same expression - only one that produces the same results.
	 * 
	 * Players may agree to limit the complexity of the boolean expression in any
	 * way they choose. Suggested starting rule for a basic game: No more than 2
	 * features may be used in the expression. Increase from 2 to 3 or more to make
	 * the game harder.
	 * 
	 */

	final int SEED = 12345; // change to get new random layout, but both players need the same seed
	final int RANGE = 64;	// should stay at 64 unless the number of shape attributes is altered
	final int ROWS = 8;		// game grid looks best as a square
	final int BOX_SIZE = 64;  // not related to RANGE
	Shape[] shapeArr;

	public BoolingPanel2() {
		int dim = BOX_SIZE * ROWS + 1;
		setPreferredSize(new Dimension(dim, dim));
		setBackground(Color.black);
		shapeArr = fillArr();
		shapeArr = fillArr();
	}
	
	/**
	 * chooses which shapes to highlight bassed on a combinsation of their attributes
	 */
	public boolean booling(Shape s) {
		// ***************
		// * CHANGE HERE *
		// ***************
		return (s.isDiamond);
	}
	/**
	 * Draws game grid, invokes draw method of each Shape object and
	 * invokes the booling() method to determine which shapes shuold 
	 * be highlighted
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.PLAIN, BOX_SIZE / 2));
		for (int i = 0; i < shapeArr.length; i++) {
			int x = BOX_SIZE * (i % ROWS);
			int y = BOX_SIZE * (i / ROWS);
			shapeArr[i].draw(g, x, y);
			g.setColor(Color.white);
			int boxMargin = BOX_SIZE / 25;
			if (booling(shapeArr[i])) {
				g.drawRoundRect(x + boxMargin, y + boxMargin, BOX_SIZE - (boxMargin * 2), BOX_SIZE - (boxMargin * 2),BOX_SIZE / 4, BOX_SIZE / 4);
			}
		}	
	}


	/**
	 * Creates an array making the game grid.
	 * There will be one Shape of each combination of attributes, 
	 * and the array will be randomly ordered.
	 * @return an array of Shape objects if size RANGE
	 * 
	 */
	public Shape[] fillArr() {
		Shape[] s = new Shape[RANGE];

		ArrayList<Integer> list = new ArrayList<Integer>(64);
		for (int i = 0; i < s.length; i++) {
			list.add(i);
		}

		Random randGen = new Random();
		randGen.setSeed(SEED);
		for (int i = 0; i < s.length; i++) {
			int r = randGen.nextInt(list.size());
			int n = list.remove(r);
			s[i] = new Shape(n);
		}
		return s;
	}

	/**
	 * Nested inner class that defines the game pieces and
	 * creates four types of attributes to identify by
	 */
	public class Shape {

		boolean isRed, isBlue, isGreen, isYellow;
		boolean isCircle, isSquare, isTriangle, isDiamond;
		boolean isFilled, isEmpty;
		boolean isSmall, isLarge;

		public Shape(int n) {
			if (n % 4 == 0)
				isRed = true;
			if (n % 4 == 1)
				isBlue = true;
			if (n % 4 == 2)
				isGreen = true;
			if (n % 4 == 3)
				isYellow = true;
			if ((n / 4) % 4 == 0)
				isCircle = true;
			if ((n / 4) % 4 == 1)
				isSquare = true;
			if ((n / 4) % 4 == 2)
				isTriangle = true;
			if ((n / 4) % 4 == 3)
				isDiamond = true;
			if ((n / 16) % 2 == 0)
				isEmpty = true;
			if ((n / 16) % 2 == 1)
				isFilled = true;
			if ((n / 32) % 2 == 0)
				isSmall = true;
			if ((n / 32) % 2 == 1)
				isLarge = true;
		}

		public void draw(Graphics g, int x, int y) {
			int size = (int) (0.64 * BOX_SIZE);
			if (isSmall)
				size /= 2;
			int margin = (BOX_SIZE - size) / 2;
			int[] xPoints = { x + BOX_SIZE / 2, x + BOX_SIZE - margin, x + margin };
			int[] yPoints = { y + margin, y + BOX_SIZE - margin, y + BOX_SIZE - margin };
			Polygon t = new Polygon(xPoints, yPoints, 3);
			int[] xPoints2 = { x + BOX_SIZE / 2, x + BOX_SIZE - margin, x + BOX_SIZE / 2, x + margin };
			int[] yPoints2 = { y + margin, y + BOX_SIZE / 2, y + BOX_SIZE - margin, y + BOX_SIZE / 2 };
			Polygon d = new Polygon(xPoints2, yPoints2, 4);
			if (isRed)
				g.setColor(Color.red);
			if (isBlue)
				g.setColor(Color.blue);
			if (isGreen)
				g.setColor(Color.green);
			if (isYellow)
				g.setColor(Color.yellow);
			if (isCircle && isEmpty)
				g.drawOval(x + margin, y + margin, size, size);
			if (isSquare && isEmpty)
				g.drawRect(x + margin, y + margin, size, size);
			if (isCircle && isFilled)
				g.fillOval(x + margin, y + margin, size, size);
			if (isSquare && isFilled)
				g.fillRect(x + margin, y + margin, size, size);
			if (isTriangle && isEmpty)
				g.drawPolygon(t);
			if (isDiamond && isEmpty)
				g.drawPolygon(d);
			if (isTriangle && isFilled)
				g.fillPolygon(t);
			if (isDiamond && isFilled)
				g.fillPolygon(d);
		}
	}
}