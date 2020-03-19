package majong.ml;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class ModelReaderTest {

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
            File file = new File("src/main/resources/pai_image/test/pin/p5.png");
            int result = ModelReader.useModel(file);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}