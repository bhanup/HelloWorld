package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch: magazine.toCharArray()) {
            int count = charFrequency.getOrDefault(ch, 0);
            charFrequency.put(ch, count + 1);
        }
        for (char ch: ransomNote.toCharArray()) {
            int count = charFrequency.getOrDefault(ch, 0);
            if (count == 0) return false;
            charFrequency.put(ch, count - 1);
        }
        return true;
    }
}
