package com.leetcode;

public class LeetCode543M {
    private int diameterLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // find the longest path to the leaf element.
        // traverse to all the leaf elements from this path.
        diameterLength = 0;
        dfs(root);
        return diameterLength;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = dfs(root.left);
        int rightLength = dfs(root.right);
        diameterLength = Math.max(diameterLength, leftLength + rightLength);
        return 1 + Math.max(leftLength, rightLength);
    }
}
