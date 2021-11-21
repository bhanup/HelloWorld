package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LeetCode106Test {
    @Test
    public void simpleTest() {
        LeetCode106 cut = new LeetCode106();
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = new TreeNode(3, new TreeNode(9), 
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        assertTrue(isTreeEqual(root, cut.buildTree(inorder, postorder)));
        
    }

    private boolean isTreeEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 != null) return false;
        else if (node2 == null && node1 != null) return false;
        else if (node1 == null && node2 == null) return true;
        else return node1.val == node2.val && isTreeEqual(node1.left, node2.left) && isTreeEqual(node1.right, node2.right);
    }
}
