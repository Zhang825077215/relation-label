package com.zxp.label.service;

import com.zxp.label.Dto.NameInfo;
import com.zxp.label.Dto.Sentence;
import com.zxp.label.config.ConfigProperties;
import com.zxp.label.config.LabelOfCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SentenceService {

    @Autowired
    private RawSentenceService rawSentenceService;

    @Autowired
    private NovelService novelService;

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private LabelOfCount labelOfCount;

    public Sentence getNovelOrSentence(NameInfo nameInfo) throws Exception{
        Sentence sentence = new Sentence();
        sentence.setType(Sentence.DONE);
        if(nameInfo.getNovel() != null && nameInfo.getNovel() &&
                new Random().nextInt(10) + 1 <= configProperties.getProbability()) {
            sentence.setType(Sentence.NOVEL).setNovel(novelService.getNovel());
        }
        if(sentence.getNovel() == null) {
            sentence.setType(Sentence.RAW).setRawSentence(rawSentenceService.getNextRawSen(nameInfo.getUserName()));
        }
        sentence.setUserCount(labelOfCount.getCount(nameInfo.getUserName()));
        return sentence;

    }

}
