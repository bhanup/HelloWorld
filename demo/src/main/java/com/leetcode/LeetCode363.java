package com.leetcode;

public class LeetCode363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxK = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            int[] sumArray = new int[row];
            for (int j = i; j < col; j++) {
                for (int l = 0; l < row; l++) {
                    sumArray[l] += matrix[l][j];
                }
                int currSum = maxsubArray(sumArray, k);
                maxK = Math.max(maxK, currSum);                 
                if(maxK == k)
                    return k;
            }
        }
        return maxK;
    }

    private int maxsubArray(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        while (i < arr.length && arr[i] > k) i++;
        if (i == arr.length) return maxSum;
        int currSum = 0;
        for (; i < arr.length; i++) {
            if (currSum + arr[i] <= k && arr[i] <= k) {
                currSum = Math.max(currSum + arr[i], arr[i]);
            } else if (currSum + arr[i] <= k) {
                currSum = currSum + arr[i];
            } else if (arr[i] <= k) {
                currSum = arr[i];
            } else {
                currSum = 0;
                continue;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
