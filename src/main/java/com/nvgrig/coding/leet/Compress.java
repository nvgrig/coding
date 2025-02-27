package com.nvgrig.coding.leet;

import java.util.ArrayList;
import java.util.List;

public class Compress {
    public int compress(char[] chars) {
        List<Character> result = new ArrayList<>();
        if (chars.length == 1) {
            return 1;
        }
        char current = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (current == chars[i]) {
                count++;
            } else {
                result.add(current);
                if (count > 1) {
                    char[] digits = String.valueOf(count).toCharArray();
                    for (int j = 0; j < digits.length; j++) {
                        result.add(digits[j]);
                    }
                }
                count = 1;
                current = chars[i];
            }
        }
        result.add(current);
        if (count > 1) {
            char[] digits = String.valueOf(count).toCharArray();
            for (int j = 0; j < digits.length; j++) {
                result.add(digits[j]);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            chars[i] = result.get(i);
        }
        return result.size();
    }
}
