package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode438 {

    public List<Integer> findAnagrams(String s, String p) {
        int[] pFrequency = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            pFrequency[p.charAt(i) - 'a'] += 1;
        }
        int[] wordFrequency = new int[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (wordFrequency[index] < pFrequency[index]) {
                wordFrequency[index]++;
                count++;
                if (count == p.length()) {
                    int firstCharIndex = i - count + 1;
                    result.add(firstCharIndex);
                    wordFrequency[s.charAt(firstCharIndex) - 'a']--;
                    count--;
                }
            } else if (pFrequency[index] == 0) {
                count = 0;
                wordFrequency = new int[26];
            } else if (wordFrequency[index] == pFrequency[index]) {
                int firstCharIndex = i - count;
                while (s.charAt(firstCharIndex) != s.charAt(i)) {
                    wordFrequency[s.charAt(firstCharIndex) - 'a']--;
                    count--;
                    firstCharIndex++;
                }
            }
        }
        return result;
    }
}
