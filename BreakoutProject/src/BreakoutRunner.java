import javax.swing.JFrame;

public class BreakoutRunner {
	
	public static void main(String[] args) {
	    JFrame f = new JFrame("Animation Test"); 
	    BreakoutPanel p = new BreakoutPanel();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.add(p);
	    f.pack();
	    f.setVisible(true);
	    p.setFocusable(true);
	    p.requestFocusInWindow();
	    p.run();
	}
}
