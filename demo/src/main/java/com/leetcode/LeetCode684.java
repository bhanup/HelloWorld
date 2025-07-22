package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode684 {
    public int[] findRedundantConnection(int[][] edges) {
        // Assumptions that the graph is connected. We would need merges.
        // a list of sets to denote the connected components
        int count = 0;
        Map<Integer, Integer> connectedMap = new HashMap<>();
        Map<Integer, Set<Integer>> disjointGraphs = new HashMap<>();
        int[] redundantConnection = new int[2];
        for (int i = 0; i < edges.length; i++) {
            if (connectedMap.containsKey(edges[i][0]) || connectedMap.containsKey(edges[i][1])) {
                int countFirst = connectedMap.getOrDefault(edges[i][0], 0);
                int countSecond = connectedMap.getOrDefault(edges[i][1], 0);
                if (countFirst != countSecond) {
                    // merge
                    Set<Integer> neighborsFirst = disjointGraphs.getOrDefault(countFirst, new HashSet<>());
                    Set<Integer> neighborsSecond = disjointGraphs.getOrDefault(countSecond, new HashSet<>());
                    if (neighborsFirst.size() >= neighborsSecond.size()) {
                        for (Integer neighbor: neighborsSecond) {
                            connectedMap.put(neighbor, countFirst);
                            neighborsFirst.add(neighbor);
                        }
                        connectedMap.put(edges[i][1], countFirst);
                        neighborsFirst.add(edges[i][1]);
                    } else {
                        for (Integer neighbor: neighborsFirst) {
                            connectedMap.put(neighbor, countSecond);
                            neighborsSecond.add(neighbor);
                        }
                        connectedMap.put(edges[i][0], countSecond);
                        neighborsSecond.add(edges[i][0]);
                    }
                } else {
                    redundantConnection = edges[i];
                }

            } else {
                count++;
                connectedMap.put(edges[i][0], count);
                connectedMap.put(edges[i][1], count);
                disjointGraphs.put(count, new HashSet<>());
                disjointGraphs.get(count).add(edges[i][0]);
                disjointGraphs.get(count).add(edges[i][1]);
            }
        }
        return redundantConnection;
    }
}
