package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeetCode980Test {
    @Test
    void testSimpleCase() {
        int grid[][] = {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
        LeetCode980 classUnderTest = new LeetCode980();
        assertEquals(2, classUnderTest.uniquePathsIII(grid));
    }
}
