package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode2593Test {

    @Test
    public void testSuccess() {
        LeetCode2593 cut = new LeetCode2593();
        assertEquals(9, cut.findScore(new int[]{2,1,3,4,5,2}));
    }
}
