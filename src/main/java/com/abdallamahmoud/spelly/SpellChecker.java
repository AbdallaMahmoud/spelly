/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdallamahmoud.spelly;

import com.abdallamahmoud.spelly.dict.Dictionary;
import com.abdallamahmoud.spelly.utils.WordUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author abdalla
 */
public abstract class SpellChecker {

    private int topForStep1 = 6;
    private int topForStep2 = 4;

    public SpellChecker() {
    }

    public SpellChecker(int topForStep1, int topForStep2) {
        this.topForStep1 = topForStep1;
        this.topForStep2 = topForStep2;
    }

    public abstract Dictionary getDictionary();

    public abstract String getLetters();

    public boolean checkWord(String word) {
        return getDictionary().exists(word);
    }

    public List<String> lookupSuggestions(String word) {
        Set<WordAndProb> suggestions1 = new TreeSet<>();
        Set<WordAndProb> suggestions2 = new TreeSet<>();

        Set<String> edits = WordUtils.norvigEdits(word, getLetters());
        for (String edit : edits) {
            processSuggestions(edit, suggestions1);
            Set<String> edits2 = WordUtils.norvigEdits(edit, getLetters());
            for (String edit2 : edits2) {
                processSuggestions(edit2, suggestions2);
            }
        }

        List<String> r = new ArrayList<>();
        
        int count = 0;
        for (WordAndProb wordAndProb : suggestions1) {
            r.add(wordAndProb.getWord());
            if (++count > topForStep1) {
                break;
            }
        }
        
        count = 0;
        for (WordAndProb wordAndProb : suggestions2) {
            r.add(wordAndProb.getWord());
            if (++count > topForStep1) {
                break;
            }
        }

        return r;
    }

    private void processSuggestions(String edit, Set<WordAndProb> suggestions) {
        int frequency = getDictionary().count(edit);
        if (frequency > 0) {
            suggestions.add(new WordAndProb(edit, (double) frequency / getDictionary().getTotalFrequencies()));
        }
    }

}
