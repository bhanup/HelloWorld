package com.leetcode;

import java.util.*;

public class LeetCode752M {
    // Breadth first search with 16 child for each of the starting position
    // Some locked codes, which need to be aborted

    private final int[][] moves = new int[][] {
        {0, 0, 0, 1},
        {0, 0, 0, -1},
        {0, 0, 1, 0},
        {0, 0, -1, 0},
        {0, 1, 0, 0},
        {0, -1, 0, 0},
        {1, 0, 0, 0},
        {-1, 0, 0, 0}
    };

    public int openLock(String[] deadends, String target) {
        Set<String> visitedNumbers = new HashSet<>(Arrays.asList(deadends));
        Deque<String> levelOrderTraversal = new ArrayDeque<>();
        levelOrderTraversal.offerLast("0000");
        visitedNumbers.add("0000");
        int turn = -1;
        while (!levelOrderTraversal.isEmpty()) {
            int size = levelOrderTraversal.size();
            turn++;
            for (int i = 0; i < size; i++) {
                String currNumber = levelOrderTraversal.pollFirst();
                System.out.println(currNumber);
                if (currNumber.equals(target)) return turn;
                for (int[] move : moves) {
                    String nextLock = getNextString(currNumber, move);
                    if (!visitedNumbers.contains(nextLock)) {
                        levelOrderTraversal.offerLast(nextLock);
                        visitedNumbers.add(nextLock);
                    }
                }
            }
            System.out.println(turn);
        }
        return -1;
    }

    private String getNextString(String currentLock, int[] move) {
        char[] lock = currentLock.toCharArray();
        for (int i = 0; i < move.length; i++) {
            int diff = (int)(lock[i] - '0');
            int newNum = diff + move[i];
            if (newNum == -1) {
                newNum = 9;
            } else if (newNum == 10) {
                newNum = 0;
            }
            lock[i] = (char)('0' + newNum);
        }
        return new String(lock);
    }
}
