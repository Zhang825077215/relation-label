package com.zxp.label.Dto;

import com.zxp.label.entity.RawSentence;
import com.zxp.label.entity.UsefulSentence;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

@Data
@Accessors(chain = true)
public class Label {
    private String relation;
    private String headType;
    private Integer headOffset;
    private Integer headEnd;

    private String tailType;
    private Integer tailOffset;
    private Integer tailEnd;
    private String userName;
    private String userIp;

    private RawSentence rawSentence;

    public UsefulSentence parseToUseSen() throws Exception{
        String raw = rawSentence.getSentence();
        if (headOffset == null || headEnd == null || tailOffset == null || tailEnd == null) {
            throw new Exception("标注数据有误!");
        }
        String head = raw.substring(headOffset, headEnd + 1);
        String tail = raw.substring(tailOffset, tailEnd + 1);
        UsefulSentence usefulSentence = new UsefulSentence();
        BeanUtils.copyProperties(this, usefulSentence);
        usefulSentence.setHead(head).setTail(tail).setVersion(0).setId(null)
        .setSentence(rawSentence.getSentence());
        return usefulSentence;
    }

}
