package com.nvgrig.coding.leet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GoatLatin {

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        Set<String> vowels = new HashSet<>(List.of("a", "e", "i", "o", "u"));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (vowels.contains(words[i].substring(0, 1).toLowerCase())) {
                result.append(words[i]).append("ma");
            } else {
                result.append(words[i].substring(1)).append(words[i].substring(0,1)).append("ma");
            }
            for (int j = 0; j < i + 1; j++) {
                result.append("a");
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}
