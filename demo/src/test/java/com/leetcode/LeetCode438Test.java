package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LeetCode438Test {
    @Test
    public void success() {
        LeetCode438 cut = new LeetCode438();
        List<Integer> result = cut.findAnagrams("cbaebabacd", "abc");
        assertEquals(result.size(), 2);
        result = cut.findAnagrams("abacbabc", "abc");
        assertEquals(result.size(), 4);
        result = cut.findAnagrams("abaacbabc", "abc");
        assertEquals(result.size(), 3);
    }
}
