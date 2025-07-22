package com.leetcode;

import java.util.PriorityQueue;

public class LeetCode2558 {
    public long pickGifts(int[] gifts, int k) {
        /**
         create a heap to pick the pile from where the gifts need to be picked up.
         The heap should be max heap
         */
        PriorityQueue<Integer> maxNumber = new PriorityQueue<>((a, b) -> b - a);
        for (int gift: gifts) {
            maxNumber.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            int highestNumber = maxNumber.poll();
            int newNumber = (int)Math.sqrt(highestNumber);
            maxNumber.offer(newNumber);
        }
        long sum = 0;
        while (!maxNumber.isEmpty()) {
            sum += maxNumber.poll();
        }
        return sum;
    }
}
