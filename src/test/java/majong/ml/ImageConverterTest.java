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

        File input = new File("src/main/resources/pai_image/resized/s1.png");
        File output = new File("src/main/resources/pai_image/3value/s1.png");

        try {
            ImageConverter.changeImageColor(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void TestForAllImageConvert() {

        File cuttedDir = new File("src/main/resources/pai_image/cutted/");
        File resizedDir = new File("src/main/resources/pai_image/resized/");
        File colorDir = new File("src/main/resources/pai_image/3value/");
        File[] fileList = cuttedDir.listFiles();

        for (File f : fileList) {
            String fileName = f.getName();
            try {
                if(fileName.endsWith(".png")) {
                    ImageConverter.resizeImage(f, new File(resizedDir + "/" + fileName), 0.1);
                    ImageConverter.changeImageColor(new File(resizedDir + "/" + fileName), new File(colorDir + "/" + fileName));
                }
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

    }

    


}