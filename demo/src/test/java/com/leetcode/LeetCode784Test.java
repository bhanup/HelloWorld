package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class LeetCode784Test {
    
    @Test
    void testSimpleCase() {
        LeetCode784 classUnderTest = new LeetCode784();
        String testString = "a1b2";
        List<String> actual = classUnderTest.letterCasePermutation("a1b2");
        assertEquals(4, actual.size());
        Set<String> stringSet = new HashSet<>();
        for (String member: actual) {
            stringSet.add(member);
            assertEquals(member.length(), testString.length());
        }
        assertEquals(stringSet.size(), actual.size());
    }
}
