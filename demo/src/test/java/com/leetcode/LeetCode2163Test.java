package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode2163Test {

    @Test
    public void simpleTest() {
        LeetCode2163 cut = new LeetCode2163();
        Assertions.assertEquals(1, cut.minimumDifference(new int[] {7, 9, 5, 8, 1, 3}));
    }
}
