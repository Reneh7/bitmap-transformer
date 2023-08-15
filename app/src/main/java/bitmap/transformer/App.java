package bitmap.transformer;
import java.io.IOException;
public class App {
    public static void main(String[] args) {
        String inputImagePath = args[0];
        try {
            System.out.println(System.getProperty("User dir"));
            String output=args[1];
            Bitmap bitmap = new Bitmap(inputImagePath);
            if( "invertColors".equals(args[2]))
            {
                bitmap.invertColors();
                System.out.println("from invertcolors");
            }
            else if ((args[2]== "convertToBlackAndWhite")) {
                bitmap.convertToBlackAndWhite();
            }
            else if ((args[2]== "randomizeColors")) {
                bitmap.randomizeColors();
            }
            bitmap.saveImage(output);
            System.out.println(args[0]);
            System.out.println(args[1]);
            System.out.println(args[2]);
            System.out.println("Transformed image saved as output.bmp");
        } catch (IOException e) {
            System.err.println("Error processing image: " + e.getMessage());
        }
    }
}
