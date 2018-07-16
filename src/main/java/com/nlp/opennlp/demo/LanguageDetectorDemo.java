package com.nlp.opennlp.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorFactory;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import opennlp.tools.langdetect.LanguageDetectorSampleStream;
import opennlp.tools.langdetect.LanguageSample;
import opennlp.tools.ml.perceptron.PerceptronTrainer;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.sentdetect.SentenceSampleStream;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.tokenize.TokenSampleStream;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;

public class LanguageDetectorDemo {

    public static void main(String[] args) {

        try {
//            InputStream is = new FileInputStream("/home/limk/develop/project/opennlp/data/langdetect-183.bin");
//            LanguageDetectorModel m = new LanguageDetectorModel(is);
//
//            String inputText = "とうざん没毛病，就是没有毛病。";
//            LanguageDetector myCategorizer = new LanguageDetectorME(m);
//
//            // Get the most probable language
//            Language bestLanguage = myCategorizer.predictLanguage(inputText);
//            System.out.println("Best language: " + bestLanguage.getLang());
//            System.out.println("Best language confidence: " + bestLanguage.getConfidence());


//            InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("/home/limk/develop/project/opennlp/data/corpus.txt"));
//
//            ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
//            ObjectStream<LanguageSample> sampleStream = new LanguageDetectorSampleStream(lineStream);
//
//            TrainingParameters params = ModelUtil.createDefaultTrainingParameters();
//            params.put(TrainingParameters.ALGORITHM_PARAM, PerceptronTrainer.PERCEPTRON_VALUE);
//            params.put(TrainingParameters.CUTOFF_PARAM, 0);
//
//            LanguageDetectorFactory factory = new LanguageDetectorFactory();
//
//            LanguageDetectorModel model = LanguageDetectorME.train(sampleStream, params, factory);
//            model.serialize(new File("/home/limk/develop/project/opennlp/data/langdetect.bin"));


//            InputStream is = new FileInputStream("/home/limk/develop/project/opennlp/data/en-token.bin");
//
//            TokenizerModel model = new TokenizerModel(is);
//
//            Tokenizer tokenizer = new TokenizerME(model);
//
//            String tokens[] = tokenizer.tokenize("Hi. How are you? This is Mike.");
//
//            for (String a : tokens)
//                System.out.println(a);
//
//            is.close();


//            Charset charset = Charset.forName("UTF-8");
//            File file = new File("/home/limk/develop/project/opennlp/data/cn.txt");
//            InputStreamFactory isFactory = new MarkableFileInputStreamFactory(file);
//            ObjectStream<String> lineStream = new PlainTextByLineStream(isFactory, charset);
//            ObjectStream<SentenceSample> sampleStream = new SentenceSampleStream(lineStream);
//
//            SentenceModel model;
//
//            try {
//                model = SentenceDetectorME.train("en", sampleStream, true, null, TrainingParameters.defaultParams());
//            }
//            finally {
//                sampleStream.close();
//            }
//
//            OutputStream modelOut = null;
//            try {
//                modelOut = new BufferedOutputStream(new FileOutputStream("/home/limk/develop/project/opennlp/data2/aa.bin"));
//                model.serialize(modelOut);
//            } finally {
//                if (modelOut != null)
//                    modelOut.close();
//            }


//            Charset charset = Charset.forName("UTF-8");
//            ObjectStream<String> lineStream = new PlainTextByLineStream((InputStreamFactory) new FileInputStream("en-sent.train"), charset);
//            ObjectStream<TokenSample> sampleStream = new TokenSampleStream(lineStream);
//
//            TokenizerModel model;
//
//            try {
//                model = TokenizerME.train("en", sampleStream, true, TrainingParameters.defaultParams());
//            }
//            finally {
//                sampleStream.close();
//            }
//
//            OutputStream modelOut = null;
//            try {
//                modelOut = new BufferedOutputStream(new FileOutputStream("/home/limk/develop/project/opennlp/data2/bb.bin"));
//                model.serialize(modelOut);
//            } finally {
//                if (modelOut != null)
//                    modelOut.close();
//            }


            InputStream modelIn = new FileInputStream("/home/limk/develop/project/opennlp/data2/aa.bin");
            SentenceModel model = new SentenceModel(modelIn);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
            String sentences[] = sentenceDetector.sentDetect("  First. aaa old, sentence. Second sentence. ");
            System.out.printf("aa="+sentences);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
