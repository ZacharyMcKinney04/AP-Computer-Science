import javax.swing.JFrame;

public class RandomRunner {
  public static void main(String[] args) {
    JFrame f = new JFrame("Random Walk"); 
    RandomPanel p = new RandomPanel();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(p);
    f.pack();
    f.setVisible(true);
  }
}