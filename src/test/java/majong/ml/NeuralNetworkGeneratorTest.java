package majong.ml;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class NeuralNetworkGeneratorTest {

    @Test public void testForExec() {

        try {
            FileUtils.forceMkdir(new File("src/test/resources/model_test/"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            NeuralNetworkGenerator nng = new NeuralNetworkGenerator();
            nng.run("src/test/resources/pai_image/pai_image_test/", "src/test/resources/model_test/");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            FileUtils.deleteDirectory(new File("src/test/resources/model_test/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}