//package bitmap.transformer;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.Test;
//
//import java.awt.Color;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//
//public class AppTest {
//
//
//    @Test
//    public void testInvertColors() throws IOException {
//        String inputImagePath = "src/test/resources/image5.png";
//        Bitmap bitMap = new Bitmap(inputImagePath);
//
//        BufferedImage originalImage = new BufferedImage(
//                bitMap.bufferedImage.getWidth(),
//                bitMap.bufferedImage.getHeight(),
//                bitMap.bufferedImage.getType()
//        );
//        originalImage.setData(bitMap.bufferedImage.getData());
//
//        bitMap.invertColors();
//
//        String outputImagePath = "src/test/resources/image6_colorinverted.bmp";
//        bitMap.writeImage(outputImagePath);
//        File outputFile = new File(outputImagePath);
//        assertTrue(outputFile.exists(), "Output image was not created");
//
//
//        for (int i = 0; i < bitMap.bufferedImage.getWidth(); i++) {
//            for (int j = 0; j < bitMap.bufferedImage.getHeight(); j++) {
//                Color originalColor = new Color(originalImage.getRGB(i, j));
//                Color invertedColor = new Color(bitMap.bufferedImage.getRGB(i, j));
//
//
//                assertEquals(originalColor.getAlpha(), invertedColor.getAlpha());
//            }
//        }
//    }
//
//
//}