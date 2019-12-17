package com.zxp.label.mapper;

import com.zxp.label.entity.RawSentence;
import org.apache.ibatis.annotations.*;


@Mapper
public interface RawSentenceMapper {
    @Select("select * from raw_sentence where flag is null or flag = '' limit 1")
    RawSentence getNextSentence(@Param("flag")String flag);

    @Select("select * from raw_sentence where id = #{id}")
    @Results({
            @Result(column = "user_name", property = "userName")
    })
    RawSentence getSentenceById(@Param("id")Integer id);

    @Select("select * from raw_sentence where flag = #{unLabeled} and user_name = #{userName}")
    @Results({
            @Result(column = "user_name", property = "userName")
    })
    RawSentence getNotLabeledSentence(@Param("userName")String userName, @Param("unLabeled") String unLabeled);

    @Update("update raw_sentence set flag = #{flag}, version = version + 1, user_name = #{userName} " +
            "where id = #{id} and version = #{version}")
    int updateRawSen(RawSentence rawSentence);

    @Insert("insert into raw_sentence(sentence, version) values(#{sentence}, #{version})")
    int insertRaw(RawSentence rawSentence);
}
