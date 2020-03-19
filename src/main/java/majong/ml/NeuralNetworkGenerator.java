/* *****************************************************************************
 * Copyright (c) 2015-2019 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package majong.ml;

import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.evaluation.classification.Evaluation;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;
import org.nd4j.linalg.learning.config.Sgd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**A Simple Multi Layered Perceptron (MLP) applied to digit classification for
 * the MNIST Dataset (http://yann.lecun.com/exdb/mnist/).
 *
 * This file builds one input layer and one hidden layer.
 *
 * The input layer has input dimension of numRows*numColumns where these variables indicate the
 * number of vertical and horizontal pixels in the image. This layer uses a rectified linear unit
 * (relu) activation function. The weights for this layer are initialized by using Xavier initialization
 * (https://prateekvjoshi.com/2016/03/29/understanding-xavier-initialization-in-deep-neural-networks/)
 * to avoid having a steep learning curve. This layer will have 1000 output signals to the hidden layer.
 *
 * The hidden layer has input dimensions of 1000. These are fed from the input layer. The weights
 * for this layer is also initialized using Xavier initialization. The activation function for this
 * layer is a softmax, which normalizes all the 10 outputs such that the normalized sums
 * add up to 1. The highest of these normalized values is picked as the predicted class.
 *
 */
public class NeuralNetworkGenerator {

    private static Logger log = LoggerFactory.getLogger(NeuralNetworkGenerator.class);

    public static void exec() throws Exception {
        //number of rows and columns in the input pictures
        /*
        final int numRows = 28;
        final int numColumns = 28;
        int outputNum = 10; // number of output classes
        int batchSize = 128; // batch size for each epoch
        int rngSeed = 123; // random number seed for reproducibility
        int numEpochs = 15; // number of epochs to perform

        //Get the DataSetIterators:
        DataSetIterator mnistTrain = new MnistDataSetIterator(batchSize, true, rngSeed);
        DataSetIterator mnistTest = new MnistDataSetIterator(batchSize, false, rngSeed);


        log.info("Build model....");
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(rngSeed) //include a random seed for reproducibility
                // use stochastic gradient descent as an optimization algorithm
                .updater(new Nesterovs(0.006, 0.9))
                .l2(1e-4)
                .list()
                .layer(new DenseLayer.Builder() //create the first, input layer with xavier initialization
                        .nIn(numRows * numColumns)
                        .nOut(1000)
                        .activation(Activation.RELU)
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .layer(new OutputLayer.Builder(LossFunction.NEGATIVELOGLIKELIHOOD) //create hidden layer
                        .nIn(1000)
                        .nOut(outputNum)
                        .activation(Activation.SOFTMAX)
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .build();

        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
        //print the score with every 1 iteration
        model.setListeners(new ScoreIterationListener(1));

        log.info("Train model....");
        model.fit(mnistTrain, numEpochs);

        log.info("Evaluate model....");
        Evaluation eval = model.evaluate(mnistTest);
        log.info(eval.stats());
        log.info("****************Example finished********************");
        */

        int seed        = 123;          // 乱数シード
        int inputNum    = 2;            // 入力数
        int outputNum   = 2;            // 出力数

        INDArray inputData = Nd4j.create(new float[]{1, 1, 1, 0, 0, 1, 0, 0}, new int[]{4, 2});
        INDArray outputData = Nd4j.create(new float[]{0, 1, 0, 1, 0, 1, 0, 0}, new int[]{4, 2});

        INDArray inputTestData = Nd4j.create(new float[]{1, 1, 1, 0, 0, 1, 0, 0}, new int[]{4, 2});
        INDArray outputTestData = Nd4j.create(new float[]{0, 1, 0, 1, 0, 1, 0, 0}, new int[]{4, 2});

        DataSet train = new DataSet(inputData, outputData);

        System.out.println(train);

        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            .seed(seed) //include a random seed for reproducibility
            // use stochastic gradient descent as an optimization algorithm
            .updater(new Nesterovs(0.006, 0.9))
            .l2(1e-4)
            .list()
            .layer(new DenseLayer.Builder() //create the first, input layer with xavier initialization
                    .nIn(inputNum)
                    .nOut(2)
                    .activation(Activation.RELU)
                    .weightInit(WeightInit.XAVIER)
                    .build())
            .layer(new OutputLayer.Builder(LossFunction.NEGATIVELOGLIKELIHOOD) //create hidden layer
                    .nIn(2)
                    .nOut(outputNum)
                    .activation(Activation.SOFTMAX)
                    .weightInit(WeightInit.XAVIER)
                    .build())
            .build();

        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
        //print the score with every 1 iteration
        model.setListeners(new ScoreIterationListener(1));

        log.info("Train model....");
        model.fit(train);

        log.info("Evaluate model....");
        Evaluation eval = new Evaluation();
        INDArray resultOutput = model.output(inputTestData);
        System.out.println(resultOutput);
        eval.eval(outputTestData, resultOutput);
        log.info(eval.stats());
        log.info("****************Example finished********************");

    }

}