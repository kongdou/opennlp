package com.nlp.opennlp.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Demo4 {

    public static void main(String[] args) {

        try {


            InputStream is = new FileInputStream("/home/limk/develop/project/opennlp/data/en-token.bin");

            TokenizerModel model = new TokenizerModel(is);

            Tokenizer tokenizer = new TokenizerME(model);

            String tokens[] = tokenizer.tokenize("Hi. How are you? This is Mike.");

            for (String a : tokens)
                System.out.println(a);

            is.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
