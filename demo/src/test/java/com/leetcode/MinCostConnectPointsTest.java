package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinCostConnectPointsTest {

    @Test
    public void simpleTest() {
        MinCostConnectPoints cut = new MinCostConnectPoints();
        int cost = cut.minCostConnectPoints(new int[][] {
            {2, -3},
            {-17, -8},
            {13, 8},
            {-17, -15}
        });
        Assertions.assertEquals(53, cost);
    }
}
