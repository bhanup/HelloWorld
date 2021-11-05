package com.leetcode;

/*
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. 
The last row of the staircase may be incomplete.
Given the integer n, return the number of complete rows of the staircase you will build.
Binary search the numbers from 1 to n. Return the number that was the last match. This is
similar to last valid build.
*/
public class LeetCode441 {
    public int arrangeCoins(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long sum = getSum(mid);
            if (sum <= n) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start-1;
    }
    
    private long getSum(int n) {
        return (long)n * ((long)n+1) /2;
    }
}
