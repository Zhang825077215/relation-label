package com.zxp.label.service;


import com.zxp.label.Dto.Sentence;
import com.zxp.label.config.ConfigProperties;
import com.zxp.label.mapper.NovelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NovelService {
    @Autowired
    private NovelMapper novelMapper;

    @Autowired
    private RawSentenceService rawSentenceService;

    @Autowired
    private ConfigProperties configProperties;

    public Sentence getNovelOrSentence(Boolean nextNovel) {
        Sentence sentence = new Sentence();
        if(nextNovel &&
                new Random().nextInt(10) + 1 <= configProperties.getProbability()) {
            sentence.setType(Sentence.NOVEL).setNovel(novelMapper.getNextNovel());
        }
        if(sentence.getType() == null ||
                (sentence.getType().equals(Sentence.NOVEL) && sentence.getNovel() == null)) {
            sentence.setType(Sentence.RAW).setRawSentence(rawSentenceService.getNextRawSen());
        }
        if(sentence.getRawSentence() == null && sentence.getNovel() == null) {
            sentence.setType(Sentence.DONE);
        }
        return sentence;

    }
}
