package com.leetcode;

/**
 * You are given a sorted array consisting of only integers where every element appears 
 * exactly twice, except for one element which appears exactly once. Return the single
 * element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 * 
 * The array being sorted and run time complexity requirement of o(log n) mandates that
 * binary search has to be used.
 */
public class LeetCode540 {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (start == end) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid+1]) {
                    start = mid+2;
                } else {
                    end = mid;
                }
            } else {
                if (nums[mid] == nums[mid-1]) {
                    start = mid+1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
