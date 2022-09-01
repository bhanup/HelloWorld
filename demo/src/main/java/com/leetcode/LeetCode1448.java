package com.leetcode;

/**
 * Simple recursive solution for the problem
 */
public class LeetCode1448 {

    private int goodNodeCount = 0;

    public int goodNodes(TreeNode root) {
        goodNodeCount = 0;
        goodNodeHelper(root, Integer.MIN_VALUE);
        return goodNodeCount;
    }

    private void goodNodeHelper(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            goodNodeCount++;
            max = root.val;
        }
        goodNodeHelper(root.left, max);
        goodNodeHelper(root.right, max);
    }
}
