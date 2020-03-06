package majong;

import majong.ml.*;

public class MajongMain {

    public static void main(String[] args) {
        //ml部分の実行
        //ml部分からデータを受け取って点数計算を行う
        MLPMnistSingleLayerExample ml = new MLPMnistSingleLayerExample();
        try{  
            ml.exec();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
