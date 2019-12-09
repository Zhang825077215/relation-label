package com.zxp.label.service;

import com.zxp.label.entity.Type;
import com.zxp.label.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeMapper typeMapper;

    public List<Type> getListTypes(String category) {
        return typeMapper.getListType(category);
    }
}
