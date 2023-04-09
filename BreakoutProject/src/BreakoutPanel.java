import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BreakoutPanel extends JPanel implements KeyListener{

	int screenWidth = 600;
	int screenHeight = 400;
	long prevTime = 0;
	int framerate = 30;
	int delayVal = 1000/framerate;
	boolean pause;
	Score score1;
	Ball ball1;
	Paddle paddle1;
	ArrayList<Animatable> objects;
	
	public BreakoutPanel() {
		Dimension screen = new Dimension(screenWidth, screenHeight);
		setPreferredSize(screen);
		setBackground(Color.BLACK);
		addKeyListener(this);
		score1 = new Score(15, 15, 93, 0);
		ball1 = new ImageBall(screenWidth / 3, screenHeight / 2);
		objects = new ArrayList<Animatable>();
		paddle1 = new Paddle(screenWidth / 2, screenHeight - 20, 0, screenWidth);
		objects.add(paddle1);
		objects.add(score1);
		objects.add(new Wall(0,-1,screenWidth,1)); //top
		objects.add(new Wall(-1,0,1,screenHeight)); //left
		objects.add(new Wall(screenWidth,0,1,screenHeight)); //right
		for(int x = Brick.WIDTH; x <= screenWidth - 2 * Brick.WIDTH; x += Brick.WIDTH) {
			for( int y = 6 * Brick.HEIGHT; y >= Brick.HEIGHT * 2; y -= Brick.HEIGHT) {
				int randomNum = (int) (Math.random() * 10);
				if (randomNum == 0) {
					objects.add(new StrongBrick(x, y));
				} else {
					objects.add(new Brick(x, y));				
				}
			}
		}

		objects.add(new GameOver());
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Animatable o : objects) {
			o.paint(g);
		}
		ball1.paint(g);
	}

	public void run() {
		while (true) {
			while(pause) {
				delay(100);
			}
			tick();
			repaint();
			calcDelay();
			delay(delayVal); 
		}
	}
	
	public void tick() {
		ball1.update();
		if(ball1.yPos > screenHeight + 200){
			ball1 = new ImageBall(screenWidth / 2, screenHeight /2);
			score1.addLives(-1);
			if(score1.getLives() <= 0){
				System.exit(0);
			}
		}
		for(Animatable o : objects) {
			o.update();
		}
		checkCollisions();
	}
	
	private void calcDelay() {
		int delta = (int)(System.currentTimeMillis() - prevTime);
		prevTime += delta;	//reset to current time		
		if(delta > 1000/framerate) {
			delayVal = Math.max(0, delayVal-1);
		}if(delta < 1000/framerate) {
			delayVal++;
		}
	}
	
	private void checkCollisions() {
		ArrayList<Animatable> deleteList = new ArrayList<Animatable>();
		for(Animatable a: objects) {
			if ( a instanceof GameObject) {
				GameObject o = (GameObject)a;
				if(ball1.isTouching(o)) {  //isTouching handles ball bounce
					if(o instanceof StrongBrick) {
						int strength = ((StrongBrick)a).getStrength();
						if (strength - 1 <= 0) {
							deleteList.add(o);
							score1.addPoints(1);
							break;
						} else {
							((StrongBrick)a).setStrength(strength - 1);
							break;
						}
					} else if (o instanceof Brick) {
						score1.addPoints(1);
						deleteList.add(o);
						break;
					}
				}
			}
		}
		objects.removeAll(deleteList);
	}

	public void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle1.changeDir(-1);
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle1.changeDir(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle1.changeDir(0);
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle1.changeDir(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'p') {
			pause = !pause;
		}else if(e.getKeyChar() == 'o' && pause) {
			tick();
			repaint();
		} else if (e.getKeyChar() == 'b'  ) {
			paddle1.superPaddle();
		}
	}

}