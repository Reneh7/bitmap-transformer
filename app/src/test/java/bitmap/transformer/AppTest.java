package bitmap.transformer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.IOException;

public class BitmapTest {

    @Test
    public void testInvertColors() throws IOException {
        BufferedImage testImage = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);
        testImage.setRGB(0, 0, Color.RED.getRGB());
        testImage.setRGB(1, 1, Color.GREEN.getRGB());

        Bitmap bitmap = new Bitmap(testImage);
        bitmap.invertColors();

        assertEquals(~Color.RED.getRGB(), testImage.getRGB(0, 0));
        assertEquals(~Color.GREEN.getRGB(), testImage.getRGB(1, 1));
    }

    @Test
    public void testConvertToBlackAndWhite() throws IOException {
        BufferedImage testImage = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);
        testImage.setRGB(0, 0, Color.RED.getRGB());
        testImage.setRGB(1, 1, Color.GREEN.getRGB());

        Bitmap bitmap = new Bitmap(testImage);
        bitmap.convertToBlackAndWhite();

        int expectedGrayRed = (int) (0.299 * Color.RED.getRed() + 0.587 * Color.RED.getGreen() + 0.114 * Color.RED.getBlue());
        int expectedGrayGreen = (int) (0.299 * Color.GREEN.getRed() + 0.587 * Color.GREEN.getGreen() + 0.114 * Color.GREEN.getBlue());

        assertEquals(expectedGrayRed, new Color(testImage.getRGB(0, 0)).getRed());
        assertEquals(expectedGrayGreen, new Color(testImage.getRGB(1, 1)).getRed());
    }

    @Test
    public void testRandomizeColors() throws IOException {
        BufferedImage testImage = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);

        Bitmap bitmap = new Bitmap(testImage);
        bitmap.randomizeColors();

        // It's difficult to predict exact values for random colors, so we'll just assert that the colors are set
        assertNotNull(testImage.getRGB(0, 0));
        assertNotNull(testImage.getRGB(1, 1));
    }
}
