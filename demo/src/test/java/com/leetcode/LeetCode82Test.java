package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LeetCode82Test {
    @Test
    void testSimpleCase() {
        ListNode head = new ListNode(new int[] {1,2,3,3,4,4,5});
        LeetCode82 cut = new LeetCode82();
        ListNode newHead = cut.deleteDuplicates(head);
        ListNode expectedList = new ListNode(new int[] {1,2,5});
        assertTrue(expectedList.compare(newHead));
    }
}
