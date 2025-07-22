package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeetCode143Test {
    @Test
    void testSimpleCase() {
        ListNode head = constructList(new int[]{1,2,3,4});
        LeetCode143 classUnderTest = new LeetCode143();
        classUnderTest.reorderList(head);
        assertEquals(true, verifyOrder(head, new int[]{1,4,2,3}));
        head = constructList(new int[]{1,2,3,4,5});
        classUnderTest.reorderList(head);
        assertEquals(true, verifyOrder(head, new int[]{1,5,2,4,3}));
    }

    private ListNode constructList(int[] nums) {
        ListNode head = null;
        ListNode prev = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode curr = new ListNode(nums[i]);
            if (prev != null) {
                prev.next = curr;
            }
            if (head == null) {
                head = curr;
            }
            prev = curr;
        }
        return head;
    }

    private boolean verifyOrder(ListNode head, int[] nums) {
        int i = 0;
        while (head != null) {
            if (i >= nums.length) return false;
            if (head.val != nums[i]) return false;
            i++;
            head = head.next;
        }
        return i == nums.length;
    }
}
