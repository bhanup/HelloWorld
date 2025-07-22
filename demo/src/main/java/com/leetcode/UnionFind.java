package com.leetcode;

public class UnionFind {
    int[] rank;
    int[] parent;

    public UnionFind(int n) {
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public boolean union(int i, int j) {
        int parenti = find(i);
        int parentj = find(j);
        if (parenti != parentj) {
            int rankx = rank[parenti];
            int ranky = rank[parentj];
            if (rankx < ranky) {
                parent[parenti] = parentj;
            } else if (ranky < rankx) {
                parent[parentj] = parenti;
            } else {
                parent[parenti] = parentj;
                rank[parentj]++;
            }
            return true;
        } else {
            return false;
        }
    }
}
