package com.zxp.label.Dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NameInfo {
    private Boolean novel;
    private String userName;
}
