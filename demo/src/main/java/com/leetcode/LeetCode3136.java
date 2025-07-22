package com.leetcode;

public class LeetCode3136 {

    private static final String VOWELS = "aeiouAEIOU";
    private static final String CONSONENTS = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        boolean vowelFound = false;
        boolean consonentFound = false;
        for (char ch: word.toCharArray()) {
            boolean isLetter = Character.isLetter(ch);
            if (!isLetter && !Character.isDigit(ch)) return false;
            if (!vowelFound && isLetter) {
                vowelFound = VOWELS.indexOf(ch) != -1;
            }
            if (!consonentFound && isLetter) {
                consonentFound = CONSONENTS.indexOf(ch) != -1;
            }
        }
        return vowelFound && consonentFound;
    }
}
