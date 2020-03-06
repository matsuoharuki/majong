package majong.ml;

import org.junit.Test;
import static org.junit.Assert.*;

public class HandRecongnizerTest {

    @Test
    public void testForExec() {

        try {
            HandRecongnizer.exec();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}