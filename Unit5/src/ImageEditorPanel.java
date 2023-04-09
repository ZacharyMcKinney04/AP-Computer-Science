import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

// @SuppressWarnings("serial")
public class ImageEditorPanel extends JPanel implements KeyListener {

    final JFileChooser saveFileChooser;
    BufferedImage imageIn;
    BufferedImage newImage;
    Color[][] imageArray;
    int width;
    int height;

    public ImageEditorPanel() {
        saveFileChooser = new JFileChooser();
        saveFileChooser.setCurrentDirectory(new File("c:\\temp"));
        saveFileChooser.setFileFilter(new FileNameExtensionFilter("PNG images", "png"));
        try {
            // the image should be in the main project folder, not in \src or \bin
            imageIn = ImageIO.read(new File("image480x320.jpg"));
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        imageArray = makeArray(imageIn);
        height = imageArray.length;
        width = imageArray[0].length;
        newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        addKeyListener(this);
    }
    
    public void paintComponent(Graphics g) {
        // paints the array pixels onto the screen
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                g.setColor(imageArray[row][col]);
                g.fillRect(col, row, 1, 1);
            }
        }
    }
    
    public Color[][] flipHorizontal(Color[][] input) {
        Color[][] output = new Color[input.length][input[0].length];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                output[row][col] = input[row][width - col - 1];
            }
        }
        return output;
    }
    
    public Color[][] flipVertical(Color[][] input) {
        Color[][] output = new Color[input.length][input[0].length];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                output[row][col] = input[height - row - 1][col];
            }
        }
        return output;
    }

    public Color[][] grayScale(Color[][] input) {
        Color[][] output = new Color[input.length][input[0].length];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                double red = .2126 * input[r][c].getRed(); // magic numbers help convert to gray
                double blu = .7152 * input[r][c].getBlue();
                double grn = .0722 * input[r][c].getGreen();
                int gray = (int) (red + blu + grn);
                output[r][c] = new Color(gray, gray, gray);
            }
        }
        return output;
    }

    public Color[][] blur(Color[][] input, int radius) {
        Color[][] output = new Color[input.length][input[0].length];

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                int count = 0;
                int red = 0;
                int grn = 0;
                int blu = 0;
                for (int i = 0 - radius; i < radius; i++) {
                    for (int j = 0 - radius; j < radius; j++)
                        if (r + i > 0 && r + i < height && c + j > 0 && c + j < width) {
                            count++;
                            red += input[r + i][c + j].getRed();
                            blu += input[r + i][c + j].getBlue();
                            grn += input[r + i][c + j].getGreen();
                        }
                }
                output[r][c] = new Color(red/count, grn/count, blu/count);
            }
        }
        return output;
    }

    // this is currently not working. numerator will equal 0 and make pic black
    public Color[][] blurGaus(Color[][] input) {
        Color[][] output = new Color[input.length][input[0].length];
        int heightHalf = height / 2;
        int widthHalf = width / 2;
        int standardDev = 1;
        int devSqr = standardDev * standardDev;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                double xDifSqr = (heightHalf - r) * (heightHalf - r);
                double yDifSqr = (widthHalf - c) * (widthHalf - c);
                double numerator = Math.exp(- ((xDifSqr + yDifSqr) / (2 * devSqr)));
                double denominator = 2 * devSqr * Math.PI;
                double modifier = (numerator / denominator);
                int red = (int) (modifier * input[r][c].getRed());
                int blu = (int) (modifier * input[r][c].getBlue());
                int grn = (int) (modifier * input[r][c].getGreen());
                if (red > 255){
                    red = 255;
                } else if (red < 0) red = 0;
                if (grn > 255){
                    grn = 255;
                } else if (grn < 0) grn = 0;
                if (blu > 255){
                    blu = 255;
                } else if (blu < 0) blu = 0;
                output[r][c] = new Color(red, grn, blu);
            }
        }
        return output;
    }

    public Color[][] brg(Color[][] input) {
        Color[][] output = new Color[input.length][input[0].length];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                int red = input[r][c].getRed();
                int grn = input[r][c].getGreen();
                int blu = input[r][c].getBlue();
                output[r][c] = new Color(blu, red, grn);
            }
        }
        return output;
    }
    public Color[][] gbr(Color[][] input) {
        Color[][] output = new Color[input.length][input[0].length];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                int red = input[r][c].getRed();
                int grn = input[r][c].getGreen();
                int blu = input[r][c].getBlue();
                output[r][c] = new Color(grn, blu, red);
            }
        }
        return output;
    }
    public Color[][] grb(Color[][] input) {
        Color[][] output = new Color[input.length][input[0].length];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                int red = input[r][c].getRed();
                int grn = input[r][c].getGreen();
                int blu = input[r][c].getBlue();
                output[r][c] = new Color(grn, red, blu);
            }
        }
        return output;
    }
    public Color[][] bright(Color[][] input, boolean amplify, int mod) {
        Color[][] output = new Color[input.length][input[0].length];

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (!amplify) mod = 0 - mod;
                int red = input[r][c].getRed() + mod;
                int grn = input[r][c].getGreen() + mod;
                int blu = input[r][c].getBlue() + mod;
                if (red > 255){
                    red = 255;
                } else if (red < 0) red = 0;
                if (grn > 255){
                    grn = 255;
                } else if (grn < 0) grn = 0;
                if (blu > 255){
                    blu = 255;
                } else if (blu < 0) blu = 0;
                output[r][c] = new Color(red, grn, blu);
            }
        }
        return output;
    }

    public Color[][] makeArray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Color[][] result = new Color[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color c = new Color(image.getRGB(col, row), true);
                result[row][col] = c;
            }
        }
        System.out.println("Loaded image: width:  " + width + "  height: " + height);
        System.out.printf("Controls \n 1: Horizontal Flip \n 2: Vertical Flip \n");
        System.out.printf(" 3: GrayScale \n 4: Blur \n 5: Fancy Blur \n");
        System.out.printf(" 6: BRG \n 7: GBR \n 8: GRB \n");
        System.out.printf(" 9: Brightness Up \n 0: Brightness Down \n");
        System.out.printf(" S to save \n");
        return result;
    }

    public void save() {
        int returnValue = saveFileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(newImage,"png",saveFileChooser.getSelectedFile());
            } catch (IOException ioe) {
                System.out.println("Couldn't save");
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '1') {
            System.out.println("Flipping Horizontal");
            imageArray = flipHorizontal(imageArray);
        }
        if (e.getKeyChar() == '2') {
            System.out.println("Flipping vertical");
            imageArray = flipVertical(imageArray);
        }
        if (e.getKeyChar() == '3') {
            System.out.println("Black and white");
            imageArray = grayScale(imageArray);
        }
        if (e.getKeyChar() == '4') {
            System.out.println("Blurring");
            imageArray = blur(imageArray, 5);
        }
        if (e.getKeyChar() == '5') {
            System.out.println("Gaussian Blur");
            imageArray = blurGaus(imageArray);
        }
        if (e.getKeyChar() == '6') {
            System.out.println("Color Switch red to green, green to blue, blue to red");
            imageArray = brg(imageArray);
        }
        if (e.getKeyChar() == '7') {
            imageArray = gbr(imageArray);
        }
        if (e.getKeyChar() == '8') {
            imageArray = grb(imageArray);
        }
        if (e.getKeyChar() == '9') {
            System.out.println("Brightness up");
            imageArray = bright(imageArray, true, 20);
        }
        if (e.getKeyChar() == '0') {
            System.out.println("Brightness down");
            imageArray = bright(imageArray, false, 20);
        }
        if (e.getKeyChar() == 's') {
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    newImage.setRGB(col, row, imageArray[row][col].getRGB());
                }
            }
            save();
        }
        repaint();
    }
    public void keyPressed(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
    }
}