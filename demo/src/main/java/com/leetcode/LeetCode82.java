package com.leetcode;

/*
Create a dummy node with the next pointer as head.
*/
public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode prev = sentinel;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }
}
