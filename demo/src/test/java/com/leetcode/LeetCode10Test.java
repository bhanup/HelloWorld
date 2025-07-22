package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode10Test {

    @Test
    public void simpleTest() {
        LeetCode10 cut = new LeetCode10();
        Assertions.assertFalse(cut.isMatch("aa", "a"));
        Assertions.assertTrue(cut.isMatch("aa", "a*"));
        Assertions.assertTrue(cut.isMatch("ab", ".*"));
        Assertions.assertTrue(cut.isMatch("aab", "c*a*b"));
    }
}
