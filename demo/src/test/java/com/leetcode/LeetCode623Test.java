package com.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCode623Test {
    
    @Test
    public void testSimpleCase() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        LeetCode623 cut = new LeetCode623();
        cut.addOneRow(root, 1, 3);
    }
}
