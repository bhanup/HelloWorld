package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode347M {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(k, (a, b) -> Integer.compare(a[1], b[1]));
        for (int num : nums) {
            int count = frequencyMap.getOrDefault(num, 0);
            count++;
            frequencyMap.put(num, count);

        }
        for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            if (heap.size() < k) {
                heap.offer(new int[]{entry.getKey(), entry.getValue()});
            } else if (heap.peek()[1] < entry.getValue()) {
                heap.poll();
                heap.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] topKElement = new int[heap.size()];
        int i = 0;
        while(!heap.isEmpty()) {
            topKElement[i] = heap.poll()[0];
            i++;
        }
        return topKElement;
    }
}
