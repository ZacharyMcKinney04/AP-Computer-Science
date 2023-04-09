import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel{
  static final long serialVersionUID = 1;

  public MyPanel(){
    setPreferredSize(new Dimension(300,300));
    setBackground(Color.BLUE);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Color myBrown = new Color (165,42,42);
    Color mySilver= new Color (192,192,192);
    int xMargin = 0;
    int yMargin = 0;
    int windowWidth = this.getWidth();          

    g.setColor(Color.BLACK);
    g.setFont(new Font("DialogInput", Font.BOLD, 18));
    g.drawString("A Seesaw and the Sun",xMargin + 42, yMargin + 25); //title
    g.setColor(Color.GREEN);
    g.fillRect(xMargin + 0, yMargin + 250, windowWidth,50); //grass
    g.setColor(Color.YELLOW);
    g.fillOval(xMargin + 250, yMargin + 70, 30,30); //sun
    g.setColor(mySilver);
    int [] xpoints = {xMargin + 148,xMargin + 178,xMargin + 118};
    int [] ypoints = {yMargin + 202, yMargin + 250, yMargin + 250};
    int nPoints = 3;
    g.fillPolygon(xpoints, ypoints, nPoints); //seesaw triangle
    g.setColor(myBrown);
    g.fillRect(xMargin + 60, yMargin + 180,175,25); //seesaw wood
    }  
}