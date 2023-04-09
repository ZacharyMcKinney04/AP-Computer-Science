import javax.swing.JFrame;

public class AnimationRunner {
	
	public static void main(String[] args) {
	    JFrame f = new JFrame("Animation Project"); 
	    AnimationPanel p = new AnimationPanel(500, 500);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.add(p);
	    f.pack();
	    f.setVisible(true);
	    p.setFocusable(true);
	    p.requestFocusInWindow();
	    p.run();
	}
}

