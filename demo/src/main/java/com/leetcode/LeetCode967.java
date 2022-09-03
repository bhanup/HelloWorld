package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode967 {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        for (Integer i = 1; i < 10; i++) {
            generateNumbers(result, sb, i, n, k);
        }
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    private void generateNumbers(List<Integer> result, StringBuilder sb, Integer i, int n, int k) {
        int index = sb.length();
        sb.append(i.toString());
        if (sb.length() == n) {
            result.add(Integer.parseInt(sb.toString()));
            sb.deleteCharAt(index);
            return;
        }
        if (i + k <= 9) {
            generateNumbers(result, sb, i + k, n, k);
        }
        if (k != 0 && 0 <= i - k && i - k <= 9) {
            generateNumbers(result, sb, i - k, n, k);
        }
        sb.deleteCharAt(index);
    }
}
