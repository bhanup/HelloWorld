package com.leetcode;

public class LeetCode2163 {
    int minDifference;

    public long minimumDifference(int[] nums) {
        // Brute force there are 3n C n possibility of picking
        // the elements for removal
        minDifference = Integer.MAX_VALUE;
        enumerate(nums, 0, 0, 0, 0, 0);
        return minDifference;
    }

    private void enumerate(int[] nums, int i, int firstSum, int secondSum, int excludedCount, int firstCount) {
        int secondCount = i - (firstCount + excludedCount);
        int n = nums.length / 3;
        if (i >= nums.length || (secondCount == n && firstCount == n)) {
            minDifference = Math.min(minDifference, firstSum - secondSum);
            return;
        }
        if (firstCount < n && excludedCount < n) {
            // including
            enumerate(nums, i+1, firstSum + nums[i], secondSum, excludedCount, firstCount + 1);
            // excluding
            enumerate(nums, i+1, firstSum, secondSum, excludedCount+1, firstCount);
        } else if (firstCount == n && excludedCount < n) {
            // including
            enumerate(nums, i+1, firstSum, secondSum + nums[i], excludedCount, firstCount);
            // excluding
            enumerate(nums, i+1, firstSum, secondSum, excludedCount+1, firstCount);
        } else if (excludedCount == n) {
            if (firstCount < n) {
                enumerate(nums, i+1, firstSum + nums[i], secondSum, excludedCount, firstCount + 1);
            } else {
                enumerate(nums, i+1, firstSum, secondSum + nums[i], excludedCount, firstCount);
            }
        }
    }
}
