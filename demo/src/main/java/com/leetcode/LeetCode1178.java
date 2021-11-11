package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[] wordsBit = getWordsBits(words);
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            int count = 0;
            int firstBitMask = 1 << (int)(puzzles[i].charAt(0) - 'a');
            int puzzleBit = getWordBit(puzzles[i]);
            for (int j = 0; j < words.length; j++) {
                if ((wordsBit[j] & firstBitMask) != 0 && (puzzleBit & wordsBit[j]) == wordsBit[j]) {
                    count++;
                }
            }
            counts.add(count);
        }
        return counts;
    }
    
    private int[] getWordsBits(String[] words) {
        int[] wordsBit = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsBit[i] = getWordBit(words[i]);
        }
        return wordsBit;
    }

    private int getWordBit(String word) {
        int bit = 0;
        for (int i = 0; i < word.length(); i++) {
            bit |= 1 << (int)(word.charAt(i) - 'a');
        }
        return bit;
    }
}
