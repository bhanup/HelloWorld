package com.leetcode;

public class LeetCode74 {
    /**
     * https://leetcode.com/problems/search-a-2d-matrix/description/
     *
     * We can first apply binarysearch to find the row in which the number must be lying
     * Then we can apply the binary search in that row to find the index of the element
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        while (startRow < endRow) {
            int midRow = startRow + (endRow - startRow) / 2;
            if (matrix[midRow][0] <= target && matrix[midRow+1][0] > target) {
                startRow = midRow;
                break;
            } else if (matrix[midRow][0] > target) {
                endRow = midRow - 1;
            } else {
                startRow = midRow + 1;
            }
        }
        int[] arr = matrix[startRow];
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) start = start + 1;
            else end = end - 1;
        }
        return false;
    }
}
