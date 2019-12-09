package com.zxp.label.service;



import com.zxp.label.entity.Novel;
import com.zxp.label.mapper.NovelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class NovelService {
    @Autowired
    private NovelMapper novelMapper;


    public Novel getNovel() {
        return novelMapper.getNextNovel();
    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insert(Novel novel) throws Exception{
        if (novelMapper.insertNovel(novel) == 0) {
            throw new Exception("插入novel失败！");
        }
    }
}
