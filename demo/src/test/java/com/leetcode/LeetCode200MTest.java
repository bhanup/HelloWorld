package com.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCode200MTest {
    @Test
    public void simpleTest() {
        LeetCode200M1 cut = new LeetCode200M1();
        cut.numIslands(new char[][]{{'1', '0', '1', '1', '1'},
            {'1', '0', '1', '0', '1'},
            {'1', '1', '1', '0', '1'}});

    }
}
