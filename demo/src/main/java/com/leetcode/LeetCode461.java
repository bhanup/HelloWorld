package com.leetcode;

/**
 * The Hamming distance between two integers is the number of positions at which 
 * the corresponding bits are different.
 * Given two integers x and y, return the Hamming distance between them.
 * 
 * We can start from the least significant bit.
 * * Take the xor of the two numbers.
 * * Count the number of bits by anding it with 1 and then shifting it right
 */

public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int diffBits = x ^ y;
        while (diffBits != 0) {
            if ((diffBits & 1) == 1) {
                count++;
            }
            diffBits = diffBits >> 1;
        }
        return count;
    }
}
