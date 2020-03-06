package majong.ml;

import org.junit.Test;
import static org.junit.Assert.*;

public class NeuralNetworkGeneratorTest {

    @Test
    public void testForExec() {

        try {
            NeuralNetworkGenerator.exec();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}