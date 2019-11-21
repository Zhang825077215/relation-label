package com.zxp.label.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Novel {
    private Integer id;
    private String artical;
    private String flag;
    private Integer version;
}
