package com.zxp.label.service;

import com.zxp.label.entity.RawSentence;
import com.zxp.label.mapper.RawSentenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RawSentenceService {
    public static final String MODIFYING = "LABELING";
    public static final String MODIFIED1 = "USELESS";
    public static final String MPDIFIED2 =  "LABELED";

    @Autowired
    private RawSentenceMapper rawSentenceMapper;

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public RawSentence getNextRawSen() {
        RawSentence rawSentence = rawSentenceMapper.getNextSentence();
        if(rawSentence == null) {
            return null;
        }
        rawSentenceMapper.updateRawSen(rawSentence.setFlag(MODIFYING));
        return rawSentence;
    }
}
