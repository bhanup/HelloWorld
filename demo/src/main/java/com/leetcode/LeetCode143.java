package com.leetcode;

public class LeetCode143 {
    public void reorderList(ListNode head) {
        ListNode midNode = findMidNode(head);
        midNode = reverseList(midNode);
        while (head != null && midNode != null) {
            ListNode next = head.next;
            head.next = midNode;
            midNode = midNode.next;
            head.next.next = next;
            head = next;
        }
    }

    private ListNode findMidNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head.next;
        ListNode newHead = reverseList(head.next);
        tail.next = head;
        head.next = null;
        return newHead;
    }
}
