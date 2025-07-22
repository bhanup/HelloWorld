package com.leetcode;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    @Test
    public void testLowestNumber() {
        int[] useCase = new int[]{3};
        int start = 0;
        int end = 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (useCase[mid] < 3) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
    }
}
