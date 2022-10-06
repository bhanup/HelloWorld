package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TimeMap {

    public class Pair {
        String value;
        Integer timeStamp;

        Pair(String value, Integer timestamp) {
            this.value = value;
            this.timeStamp = timestamp;
        }
    }

    private Map<String, ArrayList<Pair>> data;

    public TimeMap() {
        data = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Pair> listForKey = data.getOrDefault(key, new ArrayList<Pair>());
        listForKey.add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!data.containsKey(key)) {
            return "";
        }
        ArrayList<Pair> listForKey = data.get(key);
        int start = 0;
        int end = listForKey.size();
        if (listForKey.get(start).timeStamp > timestamp) return "";
        while (start < end) {
            int mid = start + ((end - start) / 2);
            if (listForKey.get(mid).timeStamp <= timestamp) start = mid + 1;
            else end = mid;
        }
        if (end == 0) return "";
        return listForKey.get(end - 1).value;
    }
}
