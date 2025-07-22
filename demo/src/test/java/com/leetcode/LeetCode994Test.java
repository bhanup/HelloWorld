package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeetCode994Test {
    @Test
    void testSimpleCase() {
        LeetCode994 classUnderTest = new LeetCode994();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        assertEquals(classUnderTest.orangesRotting(grid), 4);
    }

    @Test
    void testSimpleCase1() {
        LeetCode994 classUnderTest = new LeetCode994();
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        assertEquals(classUnderTest.orangesRotting(grid), -1);
    }

    @Test
    void testSimpleCase2() {
        LeetCode994 classUnderTest = new LeetCode994();
        int[][] grid = {{0,2}};
        assertEquals(classUnderTest.orangesRotting(grid), 0);
    }
}
