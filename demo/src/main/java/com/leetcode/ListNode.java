package com.leetcode;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int[] arr) {
        this.val = arr[0];
        ListNode prev = this;
        for (int i = 1; i < arr.length; i++) {
            prev.next = new ListNode(arr[i]);
            prev = prev.next;
        }
    }

    boolean compare(ListNode anotherNode) {
        ListNode curr = this;
        while (curr != null && anotherNode != null && curr.val == anotherNode.val) {
            curr = curr.next;
            anotherNode = anotherNode.next;
        }
        return curr == null && anotherNode == null;
    }
}
