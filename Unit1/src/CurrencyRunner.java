import javax.swing.JFrame;

public class CurrencyRunner {
  public static void main(String[] args) {
    JFrame f = new JFrame("Currency Conversion"); 
    CurrencyPanel p = new CurrencyPanel();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(p);
    f.pack();
    f.setVisible(true);
  }
}