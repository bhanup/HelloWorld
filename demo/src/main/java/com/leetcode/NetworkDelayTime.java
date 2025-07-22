package com.leetcode;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time: times) {
            List<int[]> neighbors = edges.getOrDefault(time[0], new ArrayList<>());
            neighbors.add(new int[]{time[1], time[2]});
            edges.put(time[0], neighbors);
        }
        int[] leastTime = new int[n+1];
        Arrays.fill(leastTime, Integer.MAX_VALUE);
        leastTime[k] = 0;
        Deque<Integer> bfs = new ArrayDeque<>();
        bfs.offerLast(k);
        Set<Integer> processed = new HashSet<>();
        while (!bfs.isEmpty()) {
            int current = bfs.pollFirst();
            if (!processed.contains(current)) {
                List<int[]> neighbours = edges.getOrDefault(current, new ArrayList<>());
                for (int[] neighbor: neighbours) {
                    leastTime[neighbor[0]] = Math.min(leastTime[neighbor[0]], leastTime[current] + neighbor[1]);
                    bfs.offerLast(neighbor[0]);
                }
                processed.add(current);
            }
        }
        int networkDelay = 0;
        for (int i = 1; i < n+1; i++) {
            networkDelay = Math.max(networkDelay, leastTime[i]);
        }
        return networkDelay != Integer.MAX_VALUE ? networkDelay : -1;
    }
}
