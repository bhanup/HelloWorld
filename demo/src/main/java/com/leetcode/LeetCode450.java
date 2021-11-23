package com.leetcode;

/*
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * 
 * Solution:
 * -> if the node to be deleted doesn't have a left and right child, it can be deleted.
 * -> if the deleted node has a right child, take the left most element of the subtree
 *    if it exists. Else the node itself.
 * -> if the node to be deleted only has a left child(subtree), make the left subtree as the child
 *    of the parent node.
 */
public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            deleteRoot(root);
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    
    private TreeNode deleteRoot(TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.right != null) {
            TreeNode currRoot = root.right;
            if (currRoot.left != null) {
                TreeNode parent = root;
                TreeNode curr = currRoot;
                while (curr.left != null) {
                    parent = curr;
                    curr = curr.left;
                }
                parent.left = curr.right;
                curr.left = root.left;
                curr.right = currRoot;
                return curr;
            } else {
                currRoot.left = root.left;
                return currRoot;
            }
        } else {
            return root.left;
        }
    }
}
