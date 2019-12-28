package com.zxp.label.mapper;

import com.zxp.label.entity.UsefulSentence;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UsefulSentenceMapper {
    @Insert("insert into useful_sentence(sentence, relation, head, head_type, head_offset, tail, tail_type, tail_offset, " +
            "flag, user_name, user_ip, version) " +
            "VALUES(#{sentence}, #{relation}, #{head}, #{headType}, #{headOffset}, #{tail}, #{tailType}, #{tailOffset}, " +
            "#{flag}, #{userName}, #{userIp}, #{version})")
    int insert(UsefulSentence usefulSentence);


    @Select("select count(*) from useful_sentence where user_name = #{userName}")
    int getCountUseful(@Param("userName")String userName);

    @Select("select count(*) from useful_sentence")
    int getall();
}
