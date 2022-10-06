package com.leetcode;

import org.junit.jupiter.api.Test;

public class TimeMapTest {
    @Test
    public void testSimple() {
        TimeMap map = new TimeMap();
        map.set("foo", "bar", 1);
        map.get("foo", 1);
        map.get("foo", 2);
    }
}
