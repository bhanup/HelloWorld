package com.leetcode;

import java.util.Arrays;

public class LeetCode1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFrequency = 1;
        int currSum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            while ((right - left + 1) * nums[right] - currSum > k) {
                currSum -= nums[left];
                left++;
            }
            maxFrequency = Math.max((right - left + 1), maxFrequency);
        }
        return maxFrequency;
    }
}
