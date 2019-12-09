package com.zxp.label.service;

import com.zxp.label.entity.RawSentence;
import com.zxp.label.mapper.RawSentenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class RawSentenceService {


    @Autowired
    private RawSentenceMapper rawSentenceMapper;

    public RawSentence getNextRawSen(String userName) throws Exception{
        RawSentence rawSentence = null;
        if (!StringUtils.isEmpty(userName)) {
            rawSentence = rawSentenceMapper.getNotLabeledSentence(userName, RawSentence.MODIFYING);
        }
        if(rawSentence == null) {
            rawSentence = rawSentenceMapper.getNextSentence();
            if (rawSentence != null) {
                updateRawSentence(rawSentence.setFlag(RawSentence.MODIFYING).setUserName(userName));
            }
            rawSentence.setVersion(rawSentence.getVersion() + 1);
        }
        return rawSentence;
    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public void updateRawSentence(RawSentence sentence) throws Exception{
        if (rawSentenceMapper.updateRawSen(sentence) == 0) {
            throw new Exception("更新RawSentence失败！");
        }
    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insert(RawSentence rawSentence) throws Exception {
        if (rawSentenceMapper.insertRaw(rawSentence) == 0) {
            throw new Exception("插入RawSentence失败！");
        }
    }
}
