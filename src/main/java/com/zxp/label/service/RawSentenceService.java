package com.zxp.label.service;

import com.zxp.label.entity.RawSentence;
import com.zxp.label.mapper.RawSentenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RawSentenceService {


    @Autowired
    private RawSentenceMapper rawSentenceMapper;

    public RawSentence getNextRawSen() throws Exception{
        RawSentence rawSentence = rawSentenceMapper.getNextSentence();
        if(rawSentence == null) {
            return null;
        }
        updateRawSentence(rawSentence.setFlag(RawSentence.MODIFYING));
        return rawSentence;
    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public void updateRawSentence(RawSentence sentence) throws Exception{
        if (rawSentenceMapper.updateRawSen(sentence) == 0) {
            throw new Exception("更新RawSentence失败！");
        }
    }
}
