package com.zxp.label.entity;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Type {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private String flag;
    private Integer version;
}
