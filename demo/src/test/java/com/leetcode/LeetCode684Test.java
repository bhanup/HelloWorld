package com.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCode684Test {

    @Test
    public void testSimple() {
        LeetCode684 cut = new LeetCode684();
        int[][] edges = {
            {7,8}, {2,6},{2,8},{1,4},{9,10},{1,7},{3,9},{6,9},{3,5},{3,10}
        };
        cut.findRedundantConnection(edges);
    }
}
