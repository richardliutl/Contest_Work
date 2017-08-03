import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class solveLSB {
	public static void main(String args[]) throws IOException {
		BufferedImage image = ImageIO.read(new File("lsb.bmp"));
		String msgB = "";
		String msg = "";
		int c = 0;

		int width = image.getWidth();
		int height = image.getHeight();
		int[][] result = new int[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				result[row][col] = image.getRGB(col, row);
				msgB += (result[row][col]%2+2)%2;
				if((result[row][col]%2+2)%2 == 1)
					msg += "O";
				else
					msg += ".";
				if(c == 80) {
					msg += "\n";
					c = 0;
				}
				c++;
			}
		}
		System.out.println(msg.length());
	}
}