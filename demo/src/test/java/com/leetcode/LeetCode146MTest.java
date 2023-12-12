package com.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCode146MTest {

    @Test
    public void successfulTest() {
        LeetCode146M cut = new LeetCode146M(2);
        cut.put(1, 1);
        cut.put(2, 2);
        cut.get(1);
        cut.put(3, 3);
        cut.get(2);
        cut.put(4, 4);
        cut.get(1);
        cut.get(3);
        cut.get(4);
    }

}
