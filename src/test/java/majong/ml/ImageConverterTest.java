package majong.ml;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;


public class ImageConverterTest {

    @Test
    public void TestForResizeImage() {

        File input = new File("src/main/resources/pai_image/cutted/s1.png");
        File output = new File("src/main/resources/pai_image/resized/s1.png");

        try {
            ImageConverter.resizeImage(input, output, 0.1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}