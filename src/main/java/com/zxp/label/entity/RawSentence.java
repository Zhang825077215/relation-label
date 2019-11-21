package com.zxp.label.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RawSentence {
    private Integer id;
    private String sentence;
    private String flag;
    private Integer version;
}
