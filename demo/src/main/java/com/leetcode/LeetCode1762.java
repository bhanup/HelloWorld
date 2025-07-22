package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1762 {

    public int[] findBuildings(int[] heights) {
        List<Integer> oceanViewBuildings = new ArrayList<>();
        int heighestTillNow = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > heighestTillNow) {
                oceanViewBuildings.add(i);
                heighestTillNow = heights[i];
            }
        }
        int[] result = new int[oceanViewBuildings.size()];
        for (int i = oceanViewBuildings.size() - 1, j = 0; i >= 0; i--, j++) {
            result[j] = oceanViewBuildings.get(i);
        }
        return result;
    }
}
