package majong.ml;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;


public class ImageConverterTest {

    @Test
    public void TestForResizeImage() {

        File input = new File("src/main/resources/pai_image/cutted/m5.png");
        File output = new File("src/main/resources/pai_image/resized/m5.png");

        try {
            ImageConverter.resizeImage(input, output, 0.1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void TestForChangeImageColor() {

        File input = new File("src/main/resources/pai_image/resized/m5.png");
        File output = new File("src/main/resources/pai_image/3value/m5.png");

        try {
            ImageConverter.changeImageColor(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}