package com.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LeetCode2593 {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> elements = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Set<Integer> markedElement = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            elements.offer(new int[]{nums[i], i});
        }
        long sum = 0;
        while (!elements.isEmpty()) {
            int[] element = elements.poll();
            if (!markedElement.contains(element[1])) {
                sum += element[0];
                markedElement.add(element[1]);
                if (element[1] - 1 >= 0) {
                    markedElement.add(element[1] - 1);
                }
                if (element[1] + 1 < nums.length) {
                    markedElement.add(element[1] + 1);
                }
            }
        }
        return sum;
    }
}
