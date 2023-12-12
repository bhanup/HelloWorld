package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode200M1 {

    private Set<Integer> seenElements;
    private int rowSize;
    private int colSize;
    private int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        seenElements = new HashSet<>();
        rowSize = grid.length;
        colSize = grid[0].length;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!seenElements.contains(getIndex(i, j)) && grid[i][j] == '1') {
                    count++;
                    traverseGrid(grid, i, j);
                }
            }
        }
        return count;
    }

    private int getIndex(int i, int j) {
        return colSize * i + j;
    }

    private void traverseGrid(char[][] grid, int i, int j) {
        if (seenElements.contains(getIndex(i, j))) {
            return;
        }
        seenElements.add(getIndex(i, j));
        for (int k = 0; k < moves.length; k++) {
            int nextRow = i + moves[k][0];
            int nextCol = j + moves[k][1];
            if (nextRow >= 0 && nextRow < rowSize &&
                nextCol >= 0 && nextCol < colSize &&
                !seenElements.contains(getIndex(nextRow, nextCol)) &&
                grid[nextRow][nextCol] == '1') {
                traverseGrid(grid, nextRow, nextCol);
            }
        }
    }
}
