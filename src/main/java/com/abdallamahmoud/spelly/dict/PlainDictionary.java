/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdallamahmoud.spelly.dict;

import com.abdallamahmoud.spelly.WordsTri;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author abdalla
 */
public class PlainDictionary extends Dictionary {

    public PlainDictionary() {
    }

    @Override
    public void load(InputStream dictionaryStream) throws DictionaryLoadException {
        try {
            Scanner scanner = new Scanner(dictionaryStream);
            WordsTri wordsTri = getWordsTri();

            while (scanner.hasNext()) {
                String word = scanner.next();
                int frequency = scanner.nextInt();
//                System.out.println(word);
                wordsTri.insert(word, frequency);
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DictionaryLoadException("Could not load dictionary from stream !");
        }
    }

}
