/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdallamahmoud.spelly;

/**
 *
 * @author abdalla
 */
public class WordAndProb implements Comparable<WordAndProb> {

    private String word;
    private double probability;

    public WordAndProb(String word, double probability) {
        this.word = word;
        this.probability = probability;
    }

    public String getWord() {
        return word;
    }

    public double getProbability() {
        return probability;
    }

    @Override
    public int compareTo(WordAndProb another) {
        int compare = Double.compare(another.getProbability(), probability);
        if (compare == 0d) {
            compare = word.compareTo(another.getWord());
        }
        return compare;
    }

}
