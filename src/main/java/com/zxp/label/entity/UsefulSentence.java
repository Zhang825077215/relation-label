package com.zxp.label.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UsefulSentence {
    private Integer id;
    private String sentence;
    private String relation;
    private String head;
    private String headType;
    private Integer headOffset;

    private String tail;
    private String tailType;
    private Integer tailOffset;
    private String flag;
    private String userName;
    private String userIp;
    private Integer version;
}
