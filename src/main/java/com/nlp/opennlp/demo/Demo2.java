package com.nlp.opennlp.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class Demo2 {

    public static void main(String[] args) {

        try {
            InputStream is = new FileInputStream("/home/limk/develop/project/opennlp/data/langdetect-183.bin");
            LanguageDetectorModel m = new LanguageDetectorModel(is);

            String inputText = "とうざん没毛病，就是没有毛病。";
            LanguageDetector myCategorizer = new LanguageDetectorME(m);

            // Get the most probable language
            Language bestLanguage = myCategorizer.predictLanguage(inputText);
            System.out.println("Best language: " + bestLanguage.getLang());
            System.out.println("Best language confidence: " + bestLanguage.getConfidence());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
