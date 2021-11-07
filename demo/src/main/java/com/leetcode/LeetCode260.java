package com.leetcode;

public class LeetCode260 {
    public int[] singleNumber(int[] nums) {
        int xorOfElements = 0;
        for (int i = 0; i < nums.length; i++) {
            xorOfElements = xorOfElements ^ nums[i];
        }
        int rightMostBit = 1;
        while ((xorOfElements & rightMostBit) == 0) {
            rightMostBit = rightMostBit << 1;
        }
        int firstNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightMostBit) != 0) {
                firstNumber = firstNumber ^ nums[i];
            }
        }
        return new int[]{firstNumber, xorOfElements ^ firstNumber};
    }
}
