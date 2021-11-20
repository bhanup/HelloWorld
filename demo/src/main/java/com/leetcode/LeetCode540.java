package com.leetcode;

/**
 * You are given a sorted array consisting of only integers where every element appears 
 * exactly twice, except for one element which appears exactly once. Return the single
 * element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 * 
 * The array being sorted and run time complexity requirement of o(log n) mandates that
 * binary search has to be used. Otherwise it would have been a simple XOR of elements
 * for non-sorted elements.
 * In this case we need to handle the mid element differently in case it is even index
 * vs odd index. In one case the duplicate element could be on the right while in the
 * other case it should be in the left. If the mid element is still has valid, the first
 * half is good and we can move the start pointer to after mid elements. If not, then
 * second half is good and end needs to be moved either to mid or before mid.
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
