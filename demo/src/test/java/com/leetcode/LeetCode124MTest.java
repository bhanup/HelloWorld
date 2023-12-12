package com.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCode124MTest {

    @Test
    public void success() {
        LeetCode124M cut = new LeetCode124M();
        TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        cut.maxPathSum(root);
    }
}
