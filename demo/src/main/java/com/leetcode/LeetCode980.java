package com.leetcode;

public class LeetCode980 {

    public int uniquePathsIII(int[][] grid) {
        int zeroCount = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                } else if(grid[i][j] == 0) {
                    zeroCount++;
                }
            }
        }
        return backTrackPath(grid, row, col, zeroCount, 0);
    }

    // Change the grid to mark it visited
    private int backTrackPath(int[][] grid, int i, int j, int zeroCount, int nodeCount) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == 3) {
            return 0;
        }
        if (grid[i][j] == 2) {
            return nodeCount == zeroCount ? 1: 0;
        }
        if (grid[i][j] == 0) {
            nodeCount++;
        }
        grid[i][j] = 3;
        int count = backTrackPath(grid, i+1, j, zeroCount, nodeCount);
        count += backTrackPath(grid, i, j+1, zeroCount, nodeCount);
        count += backTrackPath(grid, i-1, j, zeroCount, nodeCount);
        count += backTrackPath(grid, i, j-1, zeroCount, nodeCount);
        grid[i][j] = 0;
        return count;
    }
}
