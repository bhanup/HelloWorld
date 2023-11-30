package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode236M {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // One approach is find the path to both the nodes.
        // start traversing the path and return the last common node.
        // The other is the modified depth first search.
        // once we have found one of the elements, start exploring the siblings.
        Deque<TreeNode> pathToP = new ArrayDeque<>();
        Deque<TreeNode> pathtoQ = new ArrayDeque<>();
        pathtoQ.offerLast(root);
        pathToP.offerLast(root);
        findPath(p, pathToP);
        findPath(q, pathtoQ);
        TreeNode resultNode = null;
        while (!pathtoQ.isEmpty() && !pathToP.isEmpty()) {
            if (pathtoQ.peekFirst() == pathToP.peekFirst()) {
                resultNode = pathtoQ.pollFirst();
                pathToP.pollFirst();
            } else {
                return resultNode;
            }
        }
        return resultNode;
    }

    private boolean findPath(TreeNode p, Deque<TreeNode> path) {
        TreeNode currNode = path.peekLast();
        if (currNode == p) {
            return true;
        }
        if (currNode.left != null) {
            path.offerLast(currNode.left);
            boolean foundLeft = findPath(p, path);
            if (foundLeft) return true;
            path.pollLast();
        }
        if (currNode.right != null) {
            path.offerLast(currNode.right);
            boolean foundRight = findPath(p, path);
            if (foundRight) return true;
            path.pollLast();
        }
        return false;
    }
}
