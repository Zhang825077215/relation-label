package com.zxp.label.Dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserCount {
    private int raw;
    private int useful;
}
