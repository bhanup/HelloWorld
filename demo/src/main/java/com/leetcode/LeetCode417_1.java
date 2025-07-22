package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create a 2D matrix to contain codes which ocean they are connected to.
 * Initialize the matrix with 0 to denote that it's not connected to any
 * ocean. If its connected to pacific then 1, if to atlantic then 2, if
 * connected to both then 3.
 * Start a DFS method to update the numbers to denote what a given point
 * is connected to. It will start with the points on the edge mark all
 * reachable points. 
 * Initialize the 2D matrix with proper values by traversing the row and
 * columns at the boundry.
 */
public class LeetCode417_1 {

    int row;
    int col;
    private static char NONE = '0';
    private static char PACIFIC = '1';
    private static char ATLANTIC = '2';
    private static char BOTH = '3';
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        List<List<Integer>> connectedElements = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println(String.format("Processing the element: %s, %s", i, j));
                if (dfs(i, j, heights[i][j], heights, new HashSet<>()) == BOTH) {
                    connectedElements.add(List.of(i, j));
                }
            }
        }
        return connectedElements;
    }

    private char dfs(int i, int j, int baseHeight, int[][] heights, Set<Integer> currentList) {
        System.out.println(String.format("dfs for the element: %s, %s", i, j));
        if (i < 0 || j < 0) return PACIFIC;
        if (i >= row || j >= col) return ATLANTIC;
        int element = i * col + j;
        if (currentList.contains(element)) return NONE;
        if (heights[i][j] > baseHeight) return NONE;
        boolean atlanticCovered = false;
        boolean pacificCovered = false;
        currentList.add(element);
        for (int k = 0; k < directions.length; k++) {
            int nextRow = i + directions[k][0];
            int nextCol = j + directions[k][1];
            char child = dfs(nextRow, nextCol, heights[i][j], heights, currentList);
            atlanticCovered = atlanticCovered || child == ATLANTIC;
            pacificCovered = pacificCovered || child == PACIFIC;
            if ((atlanticCovered && pacificCovered) || child == BOTH) {
                return BOTH;
            }
        }
        if (atlanticCovered) return ATLANTIC;
        else if (pacificCovered) return PACIFIC;
        else return NONE;
    }
}
