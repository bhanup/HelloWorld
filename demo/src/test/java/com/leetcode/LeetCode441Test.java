package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeetCode441Test {
    @Test
    void testSimpleCase() {
        LeetCode441 classUnderTest = new LeetCode441();
        assertEquals(2, classUnderTest.arrangeCoins(5));
        assertEquals(1, classUnderTest.arrangeCoins(1));
        assertEquals(1, classUnderTest.arrangeCoins(2));
        assertEquals(2, classUnderTest.arrangeCoins(3));
        assertEquals(2, classUnderTest.arrangeCoins(4));
    }
}
