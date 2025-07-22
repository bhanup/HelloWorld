package com.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCode363Test {
    @Test
    public void simpleTest() {
        LeetCode363 cut = new LeetCode363();
        cut.maxSumSubmatrix(new int[][]{{5,-4,-3,4}, {-3,-4,4,5}, {5,1,5,-4}}, 8);
    }
}
