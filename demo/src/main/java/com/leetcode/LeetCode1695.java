package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1695 {
    public int maximumUniqueSubarray(int[] nums) {
        // We just need to return the maximum sum of a unique subarray
        // We can use two pointers
        Map<Integer, Integer> indexMap = new HashMap<>();
        int maxSum = 0;
        int currSum = 0;
        int rangeStart = 0;
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                int previousIndex = indexMap.get(nums[i]);
                while (rangeStart <= previousIndex) {
                    currSum -= nums[rangeStart];
                    indexMap.remove(nums[rangeStart]);
                    rangeStart++;
                }
            }
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            indexMap.put(nums[i], i);
        }
        return maxSum;
    }
}
