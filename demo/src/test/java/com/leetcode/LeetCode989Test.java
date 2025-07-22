package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode989Test {

    @Test
    public void testSuccess() {
        LeetCode989 cut = new LeetCode989();
        assertEquals(cut.addToArrayForm(new int[]{1,2,0,0}, 34), List.of(1,2,3,4));
        assertEquals(cut.addToArrayForm(new int[]{2,7,4}, 181), List.of(4,5,5));
        assertEquals(cut.addToArrayForm(new int[]{2,1,5}, 806), List.of(1,0,2,1));
    }
}
