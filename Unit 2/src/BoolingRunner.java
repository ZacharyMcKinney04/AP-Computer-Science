import javax.swing.JFrame;
public class BoolingRunner {
	public static void main(String[] args) {
	    JFrame f = new JFrame("Booling"); 
	    BoolingPanel2 p = new BoolingPanel2();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.add(p);
	    f.pack();
	    f.setVisible(true);
	  }

}
