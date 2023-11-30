package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LeetCode347MTest {

    @Test
    public void validCase() {
        int[] items = new int[] {1, 1, 1, 2, 2, 3};
        LeetCode347M cut = new LeetCode347M();
        int[] actual = cut.topKFrequent(items, 2);
        assertArrayEquals(new int[]{1, 2}, actual);
    }
}
