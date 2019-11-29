package com.zxp.label.mapper;

import com.zxp.label.entity.Novel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface NovelMapper {
    @Select("select * from novel where flag is null or flag = '' limit 1")
    Novel getNextNovel();

    @Insert("insert into novel(artical, version) values(#{artical}, #{version})")
    int insertNovel(Novel novel);
}
