package com.leetcode;

public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        // a recursive algorithm
        return bfs(s, 0, p, 0);
    }

    private boolean bfs(String s, int sPointer, String p, int pPointer) {
        if (pPointer < p.length() - 1 && p.charAt(pPointer + 1) == '*') {
            if (sPointer >= s.length()) {
                return bfs(s, sPointer, p, pPointer + 2);
            } else if (p.charAt(pPointer) == '.' || s.charAt(sPointer) == p.charAt(pPointer)) {
                return bfs(s, sPointer, p, pPointer + 2) || bfs(s, sPointer + 1, p, pPointer);
            } else {
                return bfs(s, sPointer, p, pPointer + 2);
            }
        } else if (sPointer >= s.length() && pPointer < p.length()) {
            return false;
        } else if (pPointer >= p.length() && sPointer < s.length()) {
            return false;
        } else if (pPointer >= p.length()) {
            return true;
        } else if (p.charAt(pPointer) == '.' || s.charAt(sPointer) == p.charAt(pPointer)) {
            return bfs(s, sPointer + 1, p, pPointer + 1);
        } else {
            return false;
        }
    }
}
