/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdallamahmoud.spelly.dict;

import com.abdallamahmoud.spelly.SpellChecker;

/**
 *
 * @author abdalla
 */
public class ArabicSpellChecker extends SpellChecker {

    private PlainDictionary arDictionary;
    private static final String ARABIC_LETTERS = "ابتثجحخدذرزسشصضطظعغفقكلمنهويأإءئىةؤ";

    public ArabicSpellChecker() throws DictionaryLoadException {
        try {
            arDictionary = new PlainDictionary();
            arDictionary.load(getClass().getResourceAsStream("/dicts/ar.list"));
        } catch (DictionaryLoadException ex) {
            throw ex;
        }
    }

    @Override
    public Dictionary getDictionary() {
        return arDictionary;
    }

    @Override
    public String getLetters() {
        return ARABIC_LETTERS;
    }

}
