package com.zxp.label.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RawSentence {
    public static final String MODIFYING = "LABELING";
    public static final String MODIFIED1 = "USELESS";
    public static final String MPDIFIED2 =  "LABELED";
    public static final String NOTKNOW = "NOTKNOW";
    public static final String UNDIFINE = "UNDIFINE";

    private Integer id;
    private String sentence;
    private String userName;
    private String flag;
    private Integer version;
}
