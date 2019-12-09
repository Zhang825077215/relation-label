package com.zxp.label.mapper;

import com.zxp.label.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypeMapper {

    @Select("Select * from type where category = #{category}")
    List<Type> getListType(@Param("category")String category);
}
