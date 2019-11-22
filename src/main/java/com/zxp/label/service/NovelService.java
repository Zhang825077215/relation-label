package com.zxp.label.service;



import com.zxp.label.entity.Novel;
import com.zxp.label.mapper.NovelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class NovelService {
    @Autowired
    private NovelMapper novelMapper;


    public Novel getNovel() {
        return novelMapper.getNextNovel();

    }
}
