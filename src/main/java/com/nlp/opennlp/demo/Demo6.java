package com.nlp.opennlp.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class Demo6 {

    public static void main(String[] args) {

        try {
            InputStream modelIn = new FileInputStream("/home/limk/develop/project/opennlp/data2/aa.bin");
            SentenceModel model = new SentenceModel(modelIn);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
            String sentences[] = sentenceDetector.sentDetect("  First. aaa old, sentence. Second sentence. ");
            System.out.printf("aa="+sentences);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
