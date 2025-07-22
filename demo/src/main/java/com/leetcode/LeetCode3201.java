package com.leetcode;

public class LeetCode3201 {
    public int maximumLength(int[] nums) {
        boolean isEven = nums[0] % 2 == 0;
        int evenCount = isEven ? 1: 0;
        int oddCount = isEven ? 0: 1;
        int changeCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenCount++;
                if (!isEven) {
                    changeCount++;
                    isEven = true;
                }
            } else {
                oddCount++;
                if (isEven) {
                    changeCount++;
                    isEven = false;
                }
            }
        }
        return Math.max(evenCount, Math.max(oddCount, changeCount + 1));
    }
}
