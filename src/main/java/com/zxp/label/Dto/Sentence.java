package com.zxp.label.Dto;

import com.zxp.label.entity.Novel;
import com.zxp.label.entity.RawSentence;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Sentence {
    public static final String NOVEL = "novel";
    public static final String RAW = "raw";
    public static final String DONE = "null";
    private String type;
    private RawSentence rawSentence;
    private Novel novel;

    public Sentence(){
    }
}
