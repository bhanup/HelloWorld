package com.leetcode;

public class LeetCode869 {
    public boolean reorderedPowerOf2(int n) {
        String num = Integer.toString(n);
        int[] digits = new int[num.length()];
        int i = 0;
        for (char ch: num.toCharArray()) {
            digits[i] = ch - '0';
            i++;
        }
        return checkPermutations(digits, 0);
    }

    private boolean isPowerOf2(int[] A) {
        if (A[0] == 0) return false;
        int num = 0;
        for (int n: A) {
            num = num * 10 + n;
        }
        while (num != 1) {
            if (num % 2 == 1) return false;
            num = num >> 1;
        }
        return num == 1;
    }

    private boolean checkPermutations(int[] digits, int pos) {
        if (pos == digits.length) return isPowerOf2(digits);
        for (int i = pos; i < digits.length; i++) {
            swap(digits, pos, i);
            if (checkPermutations(digits, pos+1)) return true;
            swap(digits, i, pos);
        }
        return false;
    }

    private void swap(int[] digits, int first, int second) {
        int temp = digits[first];
        digits[first] = digits[second];
        digits[second] = temp;
    }
}
