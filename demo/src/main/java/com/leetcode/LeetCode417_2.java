package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode417_2 {
    int row;
    int col;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            dfs(0, i, pacific, heights[0][i], heights);
            dfs(row - 1, i, atlantic, heights[row - 1][i], heights);
        }
        for (int i = 0; i < row; i++) {
            dfs(i, 0, pacific, heights[i][0], heights);
            dfs(i, col - 1, atlantic, heights[i][col - 1], heights);   
        }
        List<List<Integer>> connectedList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    connectedList.add(List.of(i, j));
                }
            }
        }
        return connectedList;
    }

    private void dfs(int i, int j, boolean[][] connected, int baseHeight, int[][] heights) {
        if (i < 0 || i >= row || j < 0 || j >= col || connected[i][j] || baseHeight > heights[i][j] ) return;
        connected[i][j] = true;
        dfs(i - 1, j, connected, heights[i][j], heights);
        dfs(i + 1, j, connected, heights[i][j], heights);
        dfs(i, j - 1, connected, heights[i][j], heights);
        dfs(i, j + 1, connected, heights[i][j], heights);
    }
}
