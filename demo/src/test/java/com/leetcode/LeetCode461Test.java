package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeetCode461Test {
    @Test
    public void simpleTestCase() {
        LeetCode461 cut = new LeetCode461();
        assertEquals(2, cut.hammingDistance(1, 4));
        assertEquals(1, cut.hammingDistance(5, 4));
    }
}
