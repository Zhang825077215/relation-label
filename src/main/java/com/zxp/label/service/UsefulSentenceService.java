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
import org.springframework.util.StringUtils;

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
        int tmp = 0;
        labelOfCount.addCountRaw(label.getUserName());
        if (flag.equals(RawSentence.NOTKNOW) || flag.equals(RawSentence.MODIFIED1)) {
            ;
        }
        else if (flag.equals(RawSentence.MPDIFIED2)) {
            UsefulSentence usefulSentence = label.parseToUseSen();
            usefulSentence.setUserIp(IpUtil.getIpAddr(request));
            tmp =  usefulSentenceMapper.insert(usefulSentence);
            if (tmp > 0) {
                labelOfCount.addCountUseful(label.getUserName());
            } else {
                throw new  Exception("插入失败");
            }
        }
        setFlag(label);
        return tmp;


    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public void setFlag(Label label) throws Exception{
        RawSentence rawSentence = label.getRawSentence();
        rawSentenceService.updateRawSentence(rawSentence);
    }

    public int getCountUseful(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return usefulSentenceMapper.getall();
        }
        return usefulSentenceMapper.getCountUseful(userName);
    }
}
