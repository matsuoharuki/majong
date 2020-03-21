package majong;

import majong.ml.*;

import org.apache.commons.cli.Options;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

public class MajongMain {

    public static void main(String[] args){
        //ml部分の実行
        final String modelPath = "src/test/resources/model/";

        // コマンドラインオプションの設定
        Options options = new Options();

        // 設定方法1
        // 引数名(-t), 引数を取得するか否か, 説明
        options.addOption("l", false, "learn");
        options.addOption("r", true, "run");

        // オプションのヘルプ情報を表示する。
        //HelpFormatter hf = new HelpFormatter();
        //hf.printHelp("[opts]", options);

        // コマンドライン解析
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            if(cmd.hasOption("l")) {
                //学習を行う部分
                /*
                String dataPath = "src/main/resources/pai_image/classified";
                NeuralNetworkGenerator nng = new NeuralNetworkGenerator();
                try {
                    nng.run(dataPath, modelPath);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                */
            }

            if(cmd.hasOption("r")) {
                //学習済みのモデルを用いて牌を判定する部分
                //String path = cmd.getOptionValue("r");
                //ModelReader.useModel(new File(path.trim()), new File(modelPath));

                //計算の部分

            }

        } catch (ParseException e){
            System.err.println(e);
        }
        
    }
}
