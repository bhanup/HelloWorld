package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class LeetCode260Test {
    @Test
    void testSimpleCase() {
        int[] nums = {1,2,1,2,5,3};
        LeetCode260 cut = new LeetCode260();
        assertArrayEquals(new int[] {3,5}, cut.singleNumber(nums));
    }
}
