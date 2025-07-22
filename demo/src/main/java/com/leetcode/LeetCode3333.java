package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode3333 {
    public int possibleStringCount(String word, int k) {
        List<CharacterCount> stringRep = new ArrayList<>();
        int n = word.length();
        stringRep.add(new CharacterCount(word.charAt(0), 1));
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i-1)) {
                stringRep.get(stringRep.size() - 1).incrementCount();
            } else {
                stringRep.add(new CharacterCount(word.charAt(i), 1));
            }
        }
        int maxCharsToRemove = n - k;
        if (maxCharsToRemove == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i <= maxCharsToRemove; i++) {
            count += backTrack(stringRep, 0, i);
        }
        return count;
    }

    private int backTrack(List<CharacterCount> stringRep, int i, int charsToRemove) {
        if (charsToRemove == 0) {
            return 1;
        }
        if (i == stringRep.size()) {
            return 0;
        }
        int count = 0;
        int characterCount = stringRep.get(i).getCount();
        for (int j = 0; j <= charsToRemove && j <= characterCount - 1; j++) {
            count += backTrack(stringRep, i+1, charsToRemove - j);
        }
        return count;
    }
}

class CharacterCount {
    private final Character ch;
    private Integer count;

    public CharacterCount(Character ch, Integer count) {
        this.ch = ch;
        this.count = count;
    }

    public void incrementCount() {
        this.count++;
    }

    public Integer getCount() {
        return this.count;
    }
}
