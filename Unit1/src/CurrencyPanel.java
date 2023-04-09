import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
@SuppressWarnings("resource")
public class CurrencyPanel extends JPanel{
  static final long serialVersionUID = 1;
  double inputDollar;

  public CurrencyPanel(){
    setPreferredSize(new Dimension(300,300));
    setBackground(Color.WHITE);

    Scanner in = new Scanner(System.in);
    System.out.print("How many dollars in USD do you have? ");
    inputDollar = in.nextDouble();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //calculation variables
    final double USD_TO_EURO = .84; // 1 USD to blank ratio money
    final double USD_TO_GBP = .78;
    final int USD_TO_KNUTS = 100;
    final int KNUTS_IN_GALLEON = 493 ; // 1 galleon for 493 knuts
    final int KNUTS_IN_SICKLE = 29; // 29 KNUTS = 1 SICKLE
    double outputEuro;
    double outputGBP;
    int outputKnuts;
    int inputKnutsTotal;
    int outputSickle;
    int outputGalleon;
    
    //graphing related variables
    Color myBrown = new Color (165,42,42);
    int xMargin = 0;
    int yMargin = 0;
    int windowWidth = this.getWidth();          
    int windowWidthQuarter = (windowWidth*1/4);
    int blackBarLength = 5;
    int colorBoxLength = 70;
    int colorBoxLengthHalf = (colorBoxLength *1/2);
    int yBoxLength = yMargin + blackBarLength + colorBoxLength;
    int yBox2Length = yBoxLength; 
    int yBox3Length = 2 * yBoxLength;
    int yBox4Length = 3*yBoxLength;
    int yBar2Length = yBox3Length-blackBarLength; 
    int yBar3Length = yBox4Length-blackBarLength;
    int yBar4Length = (4*(yBoxLength))-blackBarLength;

    //conversion
    outputEuro = USD_TO_EURO * inputDollar;
    outputGBP = USD_TO_GBP * inputDollar;
    inputKnutsTotal = (int) (USD_TO_KNUTS * inputDollar);
    outputGalleon = (inputKnutsTotal / KNUTS_IN_GALLEON);
    outputSickle = ((inputKnutsTotal % KNUTS_IN_GALLEON) / KNUTS_IN_SICKLE);
    outputKnuts = ((inputKnutsTotal % KNUTS_IN_GALLEON) % KNUTS_IN_SICKLE);
    
    //strings after calulcations
    String panelUSD = String.format("USD: $%5.2f ", inputDollar);
    String panelEuro = String.format("Euros: %5.2f ", outputEuro);
    String panelGBP = String.format("Great British Pounds: %5.2f ", outputGBP);
    String panelHPM = String.format("Harry Potter Money: %5d Galleons, ", outputGalleon);  
    String panelHPM2 = String.format("%d Sickles, and %d Knuts ", outputSickle, outputKnuts);  
    
    //USD box
    g.setColor(Color.GREEN);
    g.fillRect(xMargin, yMargin, windowWidth,colorBoxLength); 
    g.setColor(Color.BLACK);
    g.fillRect(xMargin, yMargin + colorBoxLength, windowWidth,blackBarLength); 
    g.drawString(panelUSD, windowWidthQuarter, yMargin + colorBoxLengthHalf);
    
    //Euro box
    g.setColor(Color.BLUE);
    g.fillRect(xMargin, yBox2Length, windowWidth,colorBoxLength); 
    g.setColor(Color.BLACK);
    g.fillRect(xMargin, yBar2Length, windowWidth,blackBarLength); 
    g.drawString(panelEuro, windowWidthQuarter, yBox2Length + colorBoxLengthHalf);
    
    //Great British Pounds box
    g.setColor(myBrown);
    g.fillRect(xMargin, yBox3Length, windowWidth,colorBoxLength); 
    g.setColor(Color.BLACK);
    g.fillRect(xMargin, yBar3Length, windowWidth,blackBarLength); 
    g.drawString(panelGBP, windowWidthQuarter, yBox3Length + colorBoxLengthHalf);
    
    //Harry Potter Money box
    g.setColor(Color.YELLOW);
    g.fillRect(xMargin, yBox4Length, windowWidth,colorBoxLength); 
    g.setColor(Color.BLACK);
    g.fillRect(xMargin, yBar4Length, windowWidth,blackBarLength); 
    g.drawString(panelHPM + panelHPM2, windowWidthQuarter, yBox4Length + colorBoxLengthHalf);

    }  
}