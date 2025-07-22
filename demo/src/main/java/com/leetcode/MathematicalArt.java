package com.leetcode;

import java.util.*;

public class MathematicalArt {
    public long getPlusSignCount(int N, int[] L, String D) {
        if (D.length() != N || L.length != N) {
            throw new IllegalArgumentException("The length of input does not match");
        }
        Map<Integer, List<int[]>> verticalLines = new TreeMap<>();
        Map<Integer, List<int[]>> horizontalLines = new TreeMap<>();
        int[] currPosition = new int[2];
        List<int[]> horizontalLine;
        List<int[]> verticalLine;
        for (int i = 0; i < N; i++) {
            switch (D.charAt(i)) {
                case 'L':
                    // horizontal line
                    horizontalLine = horizontalLines.getOrDefault(currPosition[1], new LinkedList<>());
                    horizontalLines.put(currPosition[1], horizontalLine);
                    currPosition[0] -= L[i];
                    break;
                case 'R':
                    horizontalLine = horizontalLines.getOrDefault(currPosition[1], new LinkedList<>());
                    horizontalLines.put(currPosition[1], horizontalLine);
                    currPosition[0] += L[i];
                    break;
                case 'U':
                    verticalLine = verticalLines.getOrDefault(currPosition[1], new LinkedList<>());
                    verticalLines.put(currPosition[1], verticalLine);
                    currPosition[1] += L[i];
                    break;
                case 'D':
                    verticalLine = verticalLines.getOrDefault(currPosition[1], new LinkedList<>());
                    verticalLines.put(currPosition[1], verticalLine);
                    currPosition[1] -= L[i];
                    break;
                default:
                    throw new IllegalArgumentException("Unrecognised direction: " + D.charAt(i));
            }
        }
        return 0;
    }

    private void addRange(LinkedList<int[]> currentList, int[] newRange) {
        if (currentList.isEmpty() || newRange[1] < currentList.getFirst()[0]) {
            currentList.offerFirst(newRange);
            return;
        }
        for (int[] range: currentList) {
            // add before
            if (newRange[1] < range[0]) {

            }
            if (range[0] <= newRange[0] && newRange[0] <= range[1]) {
                // intersection
                range[1] = Math.max(range[1], newRange[1]);
                return;
            }
        }
        currentList.offerLast(newRange);
    }
}
