package com.leetcode;

public class LeetCode994 {
    /*
    * You are given an m x n grid where each cell can have one of three values:
    * 0 representing an empty cell,
    * 1 representing a fresh orange, or
    * 2 representing a rotten orange.
    * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
    * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
    * 
    * To put it differently, for each of the fresh orange the least distance to any rotten orange is required. The max of such
    * distances is the minimum required to convert all to rotten.
    * Iterate through all the cells in the grid. If you find a rotten orange, do a depth first traversal. 
    *
    */

    private int[][] leastDistance;

    public int orangesRotting(int[][] grid) {
        leastDistance = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    leastDistance[i][j] = Integer.MAX_VALUE;
                } else {
                    leastDistance[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, 0, i, j);
                }
            }
        }
        int maxDistance = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxDistance = Math.max(maxDistance, leastDistance[i][j]);
            }
        }
        return maxDistance == Integer.MAX_VALUE ? -1: maxDistance;
    }

    private void dfs(int[][] grid, int currentDistance, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        if (currentDistance != 0 && currentDistance >= leastDistance[row][col]) {
            return;
        }
        leastDistance[row][col] = currentDistance;
        dfs(grid, currentDistance + 1, row+1, col);
        dfs(grid, currentDistance + 1, row-1, col);
        dfs(grid, currentDistance + 1, row, col+1);
        dfs(grid, currentDistance + 1, row, col-1);
    }
}
