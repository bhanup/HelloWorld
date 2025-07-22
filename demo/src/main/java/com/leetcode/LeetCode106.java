package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal
 * of a binary tree and postorder is the postorder traversal of the same tree, construct
 * and return the binary tree.
 * 
 * The inorder traversal can help us in constructing the node and deciding the left
 * subtree and right subtree. We can use a recursive function for the construction of the
 * trees. We would need random access of the inorder traversal list. So we can prepare an
 * index map for it. The post order traversal list when processed from back can give the
 * root node that needs to be processed. We will first evaluate the right subtree and then
 * the left subtree. 
 */
public class LeetCode106 {
    int postOrderIndex;
    Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return getTree(inorder, 0, postorder.length - 1, postorder);
    }
    
    private TreeNode getTree(int[] inorder, int left, int right, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postOrderIndex]);
        int inorderIndex = inorderIndexMap.get(postorder[postOrderIndex]);
        postOrderIndex--;
        if (inorderIndex < right) {
            root.right = getTree(inorder, inorderIndex + 1, right, postorder);
        }
        if (inorderIndex > left) {
            root.left = getTree(inorder, left, inorderIndex - 1, postorder);
        }
        return root;
    }
}
