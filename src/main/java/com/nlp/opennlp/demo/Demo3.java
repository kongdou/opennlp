package com.nlp.opennlp.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import opennlp.tools.langdetect.LanguageDetectorFactory;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import opennlp.tools.langdetect.LanguageDetectorSampleStream;
import opennlp.tools.langdetect.LanguageSample;
import opennlp.tools.ml.perceptron.PerceptronTrainer;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;

public class Demo3 {

    public static void main(String[] args) {

        try {


            InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("/home/limk/develop/project/opennlp/data/corpus.txt"));

            ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
            ObjectStream<LanguageSample> sampleStream = new LanguageDetectorSampleStream(lineStream);

            TrainingParameters params = ModelUtil.createDefaultTrainingParameters();
            params.put(TrainingParameters.ALGORITHM_PARAM, PerceptronTrainer.PERCEPTRON_VALUE);
            params.put(TrainingParameters.CUTOFF_PARAM, 0);

            LanguageDetectorFactory factory = new LanguageDetectorFactory();

            LanguageDetectorModel model = LanguageDetectorME.train(sampleStream, params, factory);
            model.serialize(new File("/home/limk/develop/project/opennlp/data/langdetect.bin"));



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
