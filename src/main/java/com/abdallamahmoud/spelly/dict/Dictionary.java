/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdallamahmoud.spelly.dict;

import com.abdallamahmoud.spelly.WordsTri;
import java.io.InputStream;

/**
 *
 * @author abdalla
 */
public abstract class Dictionary {

    private WordsTri wordsTri = new WordsTri();

    public Dictionary() {
    }

    public abstract void load(InputStream dictionaryStream) throws DictionaryLoadException;

    public boolean exists(String word) {
        return wordsTri.exists(word);
    }

    public int count(String word) {
        return wordsTri.count(word);
    }

    protected WordsTri getWordsTri() {
        return wordsTri;
    }

    public long getTotalFrequencies() {
        return wordsTri.getTotalFrequencies();
    }

}
