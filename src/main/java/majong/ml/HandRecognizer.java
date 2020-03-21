package majong.ml;

import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.factory.Nd4j;

import java.io.File;
import java.io.IOException;

public class HandRecognizer {

    public static int useModel(File file, File modelFile){
        try{
            MultiLayerNetwork network = ModelSerializer.restoreMultiLayerNetwork(modelFile);
            int indexOfLabel = Nd4j.argMax(network.output(new NativeImageLoader(40, 30, 1).asMatrix(file))).getInt(0);
            return indexOfLabel;
        } catch (IOException e) {
            return -1; 
        }
    }
    
}