package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode784 {
    public List<String> letterCasePermutation(String s) {
        List<String> permutations = new ArrayList<>();
        backTrack(s, 0, permutations, new StringBuilder());
        return permutations;

    }

    private void backTrack(String s, int i, List<String> permutations, StringBuilder sb) {
        if (i == s.length()) {
            permutations.add(sb.toString());
            return;
        }
        if (!Character.isLetter(s.charAt(i))) {
            sb.append(s.charAt(i));
            backTrack(s, i+1, permutations, sb);
            sb.deleteCharAt(i);
            return;
        }
        sb.append(Character.toLowerCase(s.charAt(i)));
        backTrack(s, i+1, permutations, sb);
        sb.deleteCharAt(i);
        sb.append(Character.toUpperCase(s.charAt(i)));
        backTrack(s, i+1, permutations, sb);
        sb.deleteCharAt(i);
        return;
    }
}
