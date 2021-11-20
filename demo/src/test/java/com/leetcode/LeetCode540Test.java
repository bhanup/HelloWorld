package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeetCode540Test {
    @Test
    public void testSimple() {
        LeetCode540 cut = new LeetCode540();
        assertEquals(1, cut.singleNonDuplicate(new int[]{1,2,2}));
        assertEquals(2, cut.singleNonDuplicate(new int[]{1,1,2}));
        assertEquals(2, cut.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        assertEquals(10, cut.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
