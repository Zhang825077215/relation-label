package com.zxp.label.mapper;

import com.zxp.label.entity.RawSentence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface RawSentenceMapper {
    @Select("select * from raw_sentence where flag is null or flag = '' limit 1")
    RawSentence getNextSentence();

    @Update("update raw_sentence set flag = #{flag}, version = version + 1 " +
            "where id = #{id} and version = #{version}")
    int updateRawSen(RawSentence rawSentence);
}
