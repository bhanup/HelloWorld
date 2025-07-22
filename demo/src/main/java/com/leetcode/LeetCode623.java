package com.leetcode;

/**
 * The breadth first and depth first both works for this problem
 */
public class LeetCode623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        addOneRowDfs(root, val, depth - 1);
        return root;
    }

    private void addOneRowDfs(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode leftNode = new TreeNode(val);
            TreeNode rightNode = new TreeNode(val);
            leftNode.left = root.left;
            rightNode.right = root.right;
            root.left = leftNode;
            root.right = rightNode;
            return;
        }
        if (root.left != null) {
            addOneRowDfs(root.left, val, depth - 1);
        }
        if (root.right != null) {
            addOneRowDfs(root.right, val, depth - 1);
        }
    }
}
