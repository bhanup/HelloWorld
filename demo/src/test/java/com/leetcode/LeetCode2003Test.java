package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class LeetCode2003Test {
    @Test
    void testSimpleCase() {
        LeetCode2003 classUnderTest = new LeetCode2003();
        int[] parents = {-1,0,0,2};
        int[] nums = {1,2,3,4};
        assertArrayEquals(classUnderTest.smallestMissingValueSubtree(parents, nums), new int[]{5,1,1,1});
    }

    @Test
    void testSimpleCase1() {
        LeetCode2003 classUnderTest = new LeetCode2003();
        int[] parents = {-1,0,1,0,3,3};
        int[] nums = {5,4,6,2,1,3};
        assertArrayEquals(classUnderTest.smallestMissingValueSubtree(parents, nums), new int[]{7,1,1,4,2,1});
    }

    @Test
    void testSimpleCase2() {
        LeetCode2003 classUnderTest = new LeetCode2003();
        int[] parents = {-1,2,3,0,2,4,1};
        int[] nums = {2,3,4,5,6,7,8};
        assertArrayEquals(classUnderTest.smallestMissingValueSubtree(parents, nums), new int[]{1,1,1,1,1,1,1});
    }
}
