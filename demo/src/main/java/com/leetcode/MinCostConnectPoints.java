package com.leetcode;

import java.util.PriorityQueue;

public class MinCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        // the edges would be represented with weight and edges
        if (points.length == 1) {
            return 0;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i+1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                heap.offer(new int[]{distance, i, j});
            }
        }
        UnionFind uf = new UnionFind(points.length);
        int minCost = 0;
        int edgesCount = 0;
        while (edgesCount != points.length - 1 && !heap.isEmpty()) {
            int[] pickedEdge = heap.poll();
            if (uf.union(pickedEdge[1], pickedEdge[2])) {
                minCost += pickedEdge[0];
                edgesCount++;
            }
        }
        return minCost;
    }
}
