import javax.swing.JFrame;

public class FrameRunner {

  public static void main(String[] args) {
    JFrame f = new JFrame("Seesaw"); 
    MyPanel p = new MyPanel();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(p);
    f.pack();
    f.setVisible(true);
  }
}