package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class LeetCode1178Test {
    @Test
    public void simpleTest() {
        LeetCode1178 cut = new LeetCode1178();
        Integer[] expected = new Integer[]{1,1,3,2,4,0};
        assertArrayEquals(expected, cut.findNumOfValidWords(new String[]{"aaaa","asas","able","ability","actt","actor","access"},
        new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}).toArray());
    }
}
