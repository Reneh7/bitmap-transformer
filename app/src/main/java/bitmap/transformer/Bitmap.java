package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Bitmap {
    public BufferedImage inputImagePath;

    public Bitmap(String fileName) throws IOException {
        readImage(fileName);

    }

    private void readImage(String fileName) throws IOException {
        inputImagePath = ImageIO.read(new File(fileName));
    }

    public void saveImage(String fileName) throws IOException {
        File file = new File(fileName);
        ImageIO.write(inputImagePath, "bmp", file);
        System.out.println("from save " + file);
    }

    public void invertColors() {
        for (int y = 0; y < inputImagePath.getHeight(); y++) {
            for (int x = 0; x < inputImagePath.getWidth(); x++) {
                int rgb = inputImagePath.getRGB(x, y);
                int invertedRGB = ~rgb;
                inputImagePath.setRGB(x, y, invertedRGB);
            }
        }
        System.out.println("from invert");
    }

    public void convertToBlackAndWhite() {
        for (int y = 0; y < inputImagePath.getHeight(); y++) {
            for (int x = 0; x < inputImagePath.getWidth(); x++) {
                int rgb = inputImagePath.getRGB(x, y);
                int gray = (int) (0.299 * ((rgb >> 16) & 0xFF) + 0.587 * ((rgb >> 8) & 0xFF) + 0.114 * (rgb & 0xFF));
                int blackAndWhite = (gray << 16) | (gray << 8) | gray;
                inputImagePath.setRGB(x, y, blackAndWhite);
            }
        }
    }

    public void randomizeColors() {
        Random random = new Random();

        for (int y = 0; y < inputImagePath.getHeight(); y++) {
            for (int x = 0; x < inputImagePath.getWidth(); x++) {
                int red = random.nextInt(256);
                int green = random.nextInt(256);
                int blue = random.nextInt(256);

                Color randomColor = new Color(red, green, blue);
                inputImagePath.setRGB(x, y, randomColor.getRGB());
            }
        }
    }
    public BufferedImage getImage() {
        return inputImagePath;
    }
}



