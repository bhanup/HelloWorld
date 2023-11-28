package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2147 {
    public int numberOfWays(String corridor) {
        // Check if there are non-zero even number of seats
        // count how many plants are there between 2n and
        // 2n + 1 seat.
        // The number of way to install divider in each of these
        // would be count of plants + 1. multiply all such numbers
        List<Integer> countiguousPlants = new ArrayList<Integer>();
        int currSeatCount = 0;
        int currPlantCount = 0;
        boolean foundYet = false;
        for (Character ch: corridor.toCharArray()) {
            if (ch == 'S') {
                currSeatCount++;
            } else if (foundYet && currSeatCount == 0 && ch == 'P') {
                currPlantCount++;
            }
            if (currSeatCount == 2) {
                foundYet = true;
                currSeatCount = 0;
            } else if (foundYet && currSeatCount == 1) {
                countiguousPlants.add(currPlantCount + 1);
                currPlantCount = 0;
            }
        }
        if (currSeatCount == 1 || !foundYet) {
            return 0;
        }
        double ways = 1;
        for (Integer combination: countiguousPlants) {
            ways = (ways * combination) % 1000000007;
        }
        return (int)ways;
    }
}
