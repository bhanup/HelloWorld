package com.leetcode;

public class LeetCode124M {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrderTraversal(root);
        return maxSum;
    }

    private int postOrderTraversal(TreeNode root) {
        if (root.left == null && root.right == null) {
            maxSum = Math.max(root.val, maxSum);
            return root.val;
        }
        int leftSum = Integer.MIN_VALUE;
        if (root.left != null) {
            leftSum = postOrderTraversal(root.left);
        }

        int rightSum = Integer.MIN_VALUE;
        if (root.right != null) {
            rightSum = postOrderTraversal(root.right);
        }
        if (leftSum != Integer.MIN_VALUE && rightSum != Integer.MIN_VALUE) {
            int pathSum = leftSum + rightSum + root.val;
            maxSum = Math.max(maxSum, pathSum);
        }
        int maxChild = Math.max(leftSum, rightSum);
        maxSum = Math.max(maxSum, root.val + maxChild);
        maxSum = Math.max(maxSum, root.val);
        return Math.max(root.val, root.val + maxChild);
    }
}
