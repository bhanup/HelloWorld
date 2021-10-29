package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2049 {
    public int countHighestScoreNodes(int[] parents) {
        int[] subtreeCount = new int[parents.length];
        int[][] childrenList = new int[parents.length][2];
        for (int i = 0; i < parents.length; i++) {
            childrenList[i][0] = -1;
            childrenList[i][1] = -1;
        }
        for (int i = 1; i < parents.length; i++) {
            if (childrenList[parents[i]][0] != -1) {
                childrenList[parents[i]][1] = i;
            } else {
                childrenList[parents[i]][0] = i;
            }
        }
        int totalNodes = dfsSubtreeCount(0, childrenList, subtreeCount);
        long highestScore = 1;
        Map<Long, Integer> highScoreFrequency = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            long score = 1;
            if (childrenList[i][0] != -1) {
                score *= subtreeCount[childrenList[i][0]];
            }
            if (childrenList[i][1] != -1) {
                score *= subtreeCount[childrenList[i][1]];
            }
            if (parents[i] != -1) {
                score *= (totalNodes - subtreeCount[i]);
            }
            int count = highScoreFrequency.getOrDefault(score, 0);
            highScoreFrequency.put(score, count+1);
            highestScore = Math.max(highestScore, score);
        }
        return highScoreFrequency.get(highestScore);
    }
    
    private int dfsSubtreeCount(int root, int[][] childrenList, int[] subtreeCount) {
        int count = 1;
        if (childrenList[root][0] != -1) {
            count += dfsSubtreeCount(childrenList[root][0], childrenList, subtreeCount);
        }
        if (childrenList[root][1] != -1) {
            count += dfsSubtreeCount(childrenList[root][1], childrenList, subtreeCount);
        }
        subtreeCount[root] = count;
        return count;
    }
}