package com.zxp.label.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class LabelOfCount {
    ConcurrentHashMap<String, Integer> counts;

    public LabelOfCount() {
        counts = new ConcurrentHashMap<String, Integer>();
    }

    public int getCount(String userName) {
        if (userName == null || userName.equals("")) {
            return 0;
        }
        return counts.getOrDefault(userName, 0);
    }

    public void addCount(String userName) {
        if (userName == null || userName.equals("")) {
            return;
        }
        counts.putIfAbsent(userName, getCount(userName) + 1);
    }
}
