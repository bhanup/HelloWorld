package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque();
        if (root == null) return averages;
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.pollFirst();
                sum += currNode.val;
                if (currNode.left != null) {
                    queue.offerLast(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offerLast(currNode.right);
                }
            }
            averages.add(sum / levelSize);
        }
        return averages;
    }
}
