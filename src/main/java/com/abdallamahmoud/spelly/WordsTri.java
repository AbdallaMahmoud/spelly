/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdallamahmoud.spelly;

import java.util.HashMap;

/**
 *
 * @author abdalla.mahmoud
 */
public class WordsTri {

    public Character character;
    private HashMap<Character, WordsTri> mapSubTris = new HashMap<>();
    private int frequency;
    private long totalFrequencies;

    public WordsTri() {
    }

    public WordsTri(Character character) {
        this.character = character;
    }

    public WordsTri getSubTri(Character c) {
        WordsTri subTri = mapSubTris.get(c);
        if (subTri == null) {
            subTri = new WordsTri(c);
            mapSubTris.put(c, subTri);
        }
        return subTri;
    }

    public void insert(String word) {
        insert(word, 1);
    }

    public void insert(String word, int frequency) {
        insert(word.toCharArray(), 0, frequency);
        totalFrequencies += frequency;
    }

    private void insert(char[] word, int position, int frequency) {
        if (position == word.length) {
            this.frequency += frequency;
            return;
        }
        getSubTri(word[position]).insert(word, position + 1, frequency);
    }

    public boolean exists(String word) {
        return count(word) > 0;
    }

    public int count(String word) {
        return count(word.toCharArray(), 0);
    }

    private int count(char[] word, int position) {
        if (position == word.length) {
            return frequency;
        }
        WordsTri subTri = mapSubTris.get(word[position]);
        if (subTri == null) {
            return 0;
        } else {
            return subTri.count(word, position + 1);
        }
    }

    public long getTotalFrequencies() {
        return totalFrequencies;
    }

}
