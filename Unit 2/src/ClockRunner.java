import javax.swing.*;

public class ClockRunner{
  public static void main(String[] args) {
    JFrame f = new JFrame("Clock Display");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setResizable(false);
    JPanel p = new ClockPanel();
    f.add(p);
    f.pack();
    f.setVisible(true);
  }

}