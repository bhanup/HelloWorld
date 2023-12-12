package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode5MTest {

    @Test
    public void success() {
        LeetCode5M cut = new LeetCode5M();
        String actual = cut.longestPalindrome("aaaa");
        assertEquals("aaaa", actual);
    }
}
