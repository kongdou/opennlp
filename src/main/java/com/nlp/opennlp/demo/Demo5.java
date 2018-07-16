package com.nlp.opennlp.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.sentdetect.SentenceSampleStream;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;

public class Demo5 {

    public static void main(String[] args) throws IOException {

        try {


            Charset charset = Charset.forName("UTF-8");
            File file = new File("/home/limk/develop/project/opennlp/data/cn.txt");
            InputStreamFactory isFactory = new MarkableFileInputStreamFactory(file);
            ObjectStream<String> lineStream = new PlainTextByLineStream(isFactory, charset);
            ObjectStream<SentenceSample> sampleStream = new SentenceSampleStream(lineStream);

            SentenceModel model;

            OutputStream modelOut = null;
            try {
                model = SentenceDetectorME.train("en", sampleStream, true, null, TrainingParameters.defaultParams());

                modelOut = new BufferedOutputStream(new FileOutputStream("/home/limk/develop/project/opennlp/data2/aa.bin"));
                model.serialize(modelOut);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                sampleStream.close();
                if (modelOut != null)
                    modelOut.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
