package com.zxp.label.Dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MyResponseBody {
    public static final int SUCCESS = 200;
    public static final int DATAFAILURE = 400;
    public static final int SYSTEMERROR = 500;

    private Object data;
    private int code;
    private String info;

    public MyResponseBody(){
        code = SUCCESS;
    }
}
