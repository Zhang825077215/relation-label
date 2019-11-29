package com.zxp.label.service;

import com.zxp.label.entity.Novel;
import com.zxp.label.entity.RawSentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class UploadService {

    @Autowired
    private RawSentenceService rawSentenceService;

    @Autowired
    private NovelService novelService;

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public int uploadRawSentence(MultipartFile file) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String tmp = null;
        int count = 0;
        while((tmp = br.readLine()) != null) {
            String [] strs = tmp.split(",");
            RawSentence rawSentence = new RawSentence();
            rawSentence.setSentence(strs[0]).setVersion(0);
            rawSentenceService.insert(rawSentence);
            ++count;
        }
        br.close();
        return count;
    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public int uploadnovel(MultipartFile file) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String tmp = null;
        int count = 0;
        while((tmp = br.readLine()) != null) {
            Novel novel = new Novel();
            novel.setArtical(tmp).setVersion(0);
            novelService.insert(novel);
            ++count;
        }
        br.close();
        return count;
    }
}
