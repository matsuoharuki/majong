package majong.ml;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

public class HandRecognizerTest {

    /**
     * 入力した牌が字牌，萬子，筒子，索子のうちどれであるかを判定する
     * 学習部分が正しく動いているかを確認するための簡易版テスト
     * 字牌 0
     * 萬子 1
     * 筒子 2
     * 索子 3
     */
    @Test public void testForExec() {

        try {
            File modelFile = new File("src/test/resources/model/model.bin");
            File file = new File("src/test/resources/pai_image/pai_image_test/pin/p5.png");
            int result = HandRecognizer.useModel(file, modelFile);
            assertThat(result).isEqualTo(2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}