package com.zxp.label.config;

import com.zxp.label.Dto.UserCount;
import com.zxp.label.service.RawSentenceService;
import com.zxp.label.service.UsefulSentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class LabelOfCount {

    @Autowired
    private RawSentenceService rawSentenceService;

    @Autowired
    private UsefulSentenceService usefulSentenceService;

    ConcurrentHashMap<String, UserCount> counts;

    public LabelOfCount() {
        counts = new ConcurrentHashMap<String, UserCount>();
    }

    public UserCount getCount(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
        UserCount userCount = counts.get(userName);
        if (userCount == null) {
            userCount = new UserCount();
            userCount.setRaw(rawSentenceService.getCountRaw(userName))
                    .setUseful(usefulSentenceService.getCountUseful(userName));
            counts.putIfAbsent(userName, userCount);
        }
        return userCount;
    }

    public void addCountRaw(String userName) {
        UserCount userCount = getCount(userName);
        if (userCount == null) {
            return;
        }
        userCount.setRaw(userCount.getRaw() + 1);
    }

    public void addCountUseful(String userName) {
        UserCount userCount = getCount(userName);
        if (userCount == null) {
            return;
        }
        userCount.setUseful(userCount.getUseful() + 1);
    }
}
