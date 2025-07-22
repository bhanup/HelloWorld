package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeetCode130Test {
    @Test
    void testSimpleCase() {
        LeetCode130 classUnderTest = new LeetCode130();
        char[][] board = {{'X','X','X','X'},
                          {'X','O','O','X'},
                          {'X','X','O','X'},
                          {'X','O','X','X'}};
        classUnderTest.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 3 && j == 1) {
                    assertEquals('O', board[i][j]);
                } else {
                    assertEquals('X', board[i][j]);
                }
            }
        }
    }
}
