package com.zxp.label.service;

import com.zxp.label.Dto.Label;
import com.zxp.label.Utils.IpUtil;
import com.zxp.label.config.LabelOfCount;
import com.zxp.label.entity.RawSentence;
import com.zxp.label.entity.UsefulSentence;
import com.zxp.label.mapper.UsefulSentenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
public class UsefulSentenceService {

    @Autowired
    private UsefulSentenceMapper usefulSentenceMapper;

    @Autowired
    private RawSentenceService rawSentenceService;

    @Autowired
    private LabelOfCount labelOfCount;

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public int insertUsefulSen(HttpServletRequest request, Label label) throws Exception{
        String flag = label.getRawSentence().getFlag();
        setFlag(label);
        if (flag.equals(RawSentence.MODIFIED1)) {
            return 0;
        }
        UsefulSentence usefulSentence = label.parseToUseSen();
        usefulSentence.setUserIp(IpUtil.getIpAddr(request));
        int tmp =  usefulSentenceMapper.insert(usefulSentence);
        if (tmp > 0 ) {
            labelOfCount.addCount(label.getUserName());
            return tmp;
        } else {
            throw new  Exception("插入失败");
        }
    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public void setFlag(Label label) throws Exception{
        RawSentence rawSentence = label.getRawSentence().setFlag(label.getRawSentence().getFlag());
        rawSentenceService.updateRawSentence(rawSentence);
    }
}
