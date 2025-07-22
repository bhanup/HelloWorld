package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode2003 {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int[] smallestValue = new int[parents.length];
        for (int i = 0; i < nums.length; i++) {
            smallestValue[i] = 1;
        }
        int oneIndex = -1;
        for (int i = 0; i < parents.length; i++) {
            if (nums[i] == 1) {
                oneIndex = i;
                break;
            }
        }
        if (oneIndex == -1) {
            return smallestValue;
        }
        Map<Integer, Set<Integer>> childrenMap = new HashMap<>();
        for (int i = 1; i < parents.length; i++) {
            Set<Integer> children = childrenMap.getOrDefault(parents[i], new HashSet<>());
            children.add(i);
            childrenMap.put(parents[i], children);
        }
        int missingValue = 1;
        Set<Integer> visitedGene = new HashSet<>();
        int currentNode = oneIndex;
        while (currentNode != -1) {
            dfs(nums, currentNode, childrenMap, visitedGene);
            while (visitedGene.contains(missingValue)) {
                missingValue++;
            }
            smallestValue[currentNode] = missingValue;
            currentNode = parents[currentNode];
        }
        return smallestValue;
    }
    
    private void dfs(int[] nums, int node, Map<Integer, Set<Integer>> childrenMap, Set<Integer> visitedGene) {
        if (visitedGene.contains(nums[node])) {
            return;
        }
        if (childrenMap.containsKey(node)) {
            Set<Integer> children = childrenMap.get(node);
            for (Integer child: children) {
                dfs(nums, child, childrenMap, visitedGene);
            }
        }
        visitedGene.add(nums[node]);
    }
}
