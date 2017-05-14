/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdallamahmoud.spelly;

import com.abdallamahmoud.spelly.dict.ArabicSpellChecker;
import com.abdallamahmoud.spelly.dict.DictionaryLoadException;
import java.util.List;

/**
 *
 * @author abdalla
 */
public class Test {

    public static void main(String[] args) {
        try {
//            Dictionary dict = new PlainDictionary();
//            dict.load(Test.class.getResourceAsStream("/dicts/ar.list"));
//            System.out.println(dict.exists("من"));
//            System.out.println(dict.exists("شجر"));

            ArabicSpellChecker arabicSpellChecker = new ArabicSpellChecker();
            List<String> suggestions = arabicSpellChecker.lookupSuggestions("شجرر");
            for (String word : suggestions) {
                System.out.println(word);
            }
//            System.out.println(arabicSpellChecker.checkWord("من"));
//            System.out.println(arabicSpellChecker.checkWord("شجرر"));
        } catch (DictionaryLoadException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
