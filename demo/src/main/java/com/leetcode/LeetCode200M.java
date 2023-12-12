package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode200M {

    private Set<Integer> seenElements;
    private int row;
    private int col;
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        seenElements = new HashSet<>();
        row = grid.length;
        col = grid[0].length;
        int islandCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0' || seenElements.contains(getElement(i, j))) continue;
                dfs(grid, i, j);
                islandCount++;
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col
        || grid[i][j] == '0'
        || seenElements.contains(getElement(i, j))) return;
        seenElements.add(getElement(i, j));
        for (int k = 0; k < direction.length; k++) {
            dfs(grid, i + direction[k][0], j + direction[k][1]);
        }
        return;
    }

    private int getElement(int i, int j) {
        return (i * col) + j;
    }
}
