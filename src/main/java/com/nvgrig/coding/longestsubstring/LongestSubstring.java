package com.nvgrig.coding.longestsubstring;

import java.util.*;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> setOfChars = new HashSet<>();
        List<Integer> listOfLengths = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            setOfChars.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (setOfChars.contains(s.charAt(j))) {
                    listOfLengths.add(setOfChars.size());
                    setOfChars.clear();
                    break;
                } else {
                    setOfChars.add(s.charAt(j));
                }
            }
        }
        if (!setOfChars.isEmpty()) {
            listOfLengths.add(setOfChars.size());
        }
        Optional<Integer> max = listOfLengths.stream().max(Integer::compareTo);
        return max.orElse(0);
    }

}
