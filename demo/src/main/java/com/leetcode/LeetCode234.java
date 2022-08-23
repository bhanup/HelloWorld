package com.leetcode;

import java.util.Stack;

class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        int length = listLength(head);
        if (length <= 1) return true;
        int count = 1;
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        while (count <= length / 2) {
            stack.push(curr);
            curr = curr.next;
            count++;
        }
        if (length % 2 != 0) {
            curr = curr.next;
        }
        while (curr != null) {
            ListNode stackElement = stack.pop();
            if (stackElement.val != curr.val) return false;
            curr = curr.next;
        }
        return true;
    }

    private int listLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }
}