package com.leetcode;

import java.util.TreeMap;
import java.util.TreeSet;

class OddEvenJump {
    // brute force
    // odd jump start moving forward to find any number >= the current number
    // even jumps
    // Iteration2 memoize the moves so that it can be used.
    // Iteration3 memoize the boolean value.
    // Iteration3 instead of calculating the next node linearly use treeset to get the next node
    // Iternation4 instead of treeset use treemap as the previous index are not relevant and comparison would be easier

    Boolean[][] memo;

    public int oddEvenJumps(int[] arr) {
        memo = new Boolean[arr.length][2];
        TreeMap<Integer, Integer> orderedMap = new TreeMap<Integer, Integer>();
        int n = arr.length;
        memo[n-1][0] = true;
        memo[n-1][1] = true;
        int count = 1;
        orderedMap.put(arr[n-1], n-1);
        for (int i = n - 2; i >= 0; i--) {
            // oddJump
            Integer nextOddJump = orderedMap.ceilingKey(arr[i]);
            if (nextOddJump == null) {
                memo[i][0] = false;
            } else {
                memo[i][0] = memo[orderedMap.get(nextOddJump)][1];
            }
            // evenJump
            Integer nextEvenJump = orderedMap.floorKey(arr[i]);
            if (nextEvenJump == null) {
                memo[i][1] = false;
            } else {
                memo[i][1] = memo[orderedMap.get(nextEvenJump)][0];
            }
            if (memo[i][0]) count++;
            orderedMap.put(arr[i], i);
        }
        return count;
    }
}
