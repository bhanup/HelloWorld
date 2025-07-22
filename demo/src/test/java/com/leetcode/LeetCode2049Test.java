package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeetCode2049Test {
    @Test
    void testSimpleCase() {
        LeetCode2049 classUnderTest = new LeetCode2049();
        int[] parents = {-1,2,0,2,0};
        assertEquals(classUnderTest.countHighestScoreNodes(parents), 3);
    }

    @Test
    void testSimpleCase1() {
        LeetCode2049 classUnderTest = new LeetCode2049();
        int[] parents = {-1,2,0};
        assertEquals(classUnderTest.countHighestScoreNodes(parents), 2);
    }
}
