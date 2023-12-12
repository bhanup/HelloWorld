package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode752MTest {

    @Test
    public void success() {
        LeetCode752M cut = new LeetCode752M();
        String[] deadEnds = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int actual = cut.openLock(deadEnds, target);
        assertEquals(actual, 6);
    }
}
