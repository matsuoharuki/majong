package majong.ml;

import org.junit.Test;
import static org.junit.Assert.*;

public class NeuralNetworkGeneratorTest {

    @Test public void testForExec() {

        try {
            NeuralNetworkGenerator nng = new NeuralNetworkGenerator();
            nng.run("src/test/resources/pai_image_test/", "src/test/resources/model/");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}