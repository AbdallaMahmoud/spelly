/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdallamahmoud.spelly.utils;

import java.util.HashSet;

/**
 *
 * @author abdalla
 */
public class WordUtils {

    public static HashSet<String> norvigEdits(String word, String letters) {
        HashSet<String> list = new HashSet<>();
        for (int i = 0; i < word.length() + 1; i++) {
            String L = word.substring(0, i);
            String R = word.substring(i);

            if (R.length() > 0) {
                String delete = L + R.substring(1);
                list.add(delete);
            }
            if (R.length() > 1) {
                String transpose = L + R.substring(1, 2) + R.substring(0, 1) + R.substring(2);
                list.add(transpose);
            }
            if (R.length() > 0) {
                for (int j = 0; j < letters.length(); j++) {
                    char letter = letters.charAt(j);
                    String replace = L + letter + R.substring(1);
                    list.add(replace);
                }
            }
            if (true) {
                for (int j = 0; j < letters.length(); j++) {
                    char letter = letters.charAt(j);
                    String insert = L + letter + R;
                    list.add(insert);
                }
            }

        }
        return list;
    }
}
