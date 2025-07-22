package com.leetcode;

public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode greaterNodeHead = new ListNode();
        ListNode greaterNodeCurr = greaterNodeHead;
        ListNode lesserNodeHead = new ListNode();
        ListNode lesserNodeCurr = lesserNodeHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                lesserNodeCurr.next = curr;
                lesserNodeCurr = curr;
            } else {
                greaterNodeCurr.next = curr;
                greaterNodeCurr = curr;
            }
            ListNode temp = curr.next;
            curr.next = null;
            curr = temp;
        }
        if (lesserNodeHead.next != null) {
            head = lesserNodeHead.next;
            lesserNodeCurr.next = greaterNodeHead.next;
        } else {
            head = greaterNodeHead.next;
        }
        return head;
    }
}
