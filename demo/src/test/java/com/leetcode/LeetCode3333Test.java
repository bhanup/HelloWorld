package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode3333Test {

    @Test
    public void testBasic() {
        LeetCode3333 cut = new LeetCode3333();
        Assertions.assertEquals(5, cut.possibleStringCount("aabbccdd", 7));
    }
}
