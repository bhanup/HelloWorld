package com.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCode967Test {
    @Test
    public void simpleTest() {
        LeetCode967 cut = new LeetCode967();
        int[] actual = cut.numsSameConsecDiff(2, 0);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(actual[i]);
        }
    }
}
