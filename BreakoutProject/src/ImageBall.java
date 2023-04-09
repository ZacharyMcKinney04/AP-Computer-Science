import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
// import java.io.IOException;

public class ImageBall extends Ball {

	private BufferedImage image;

	public ImageBall(int x, int y) {
		super(x, y);
		String filename = "baseball.gif";
        try {
            image = ImageIO.read(new File(filename));
        } catch (Exception e) {
            image = null;
            System.err.println(e + " file:" + filename);
        }
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, (int) this.xPos - this.radius, (int) this.yPos - this.radius, 2 * this.radius, 2 * this.radius, null);
	}

}
