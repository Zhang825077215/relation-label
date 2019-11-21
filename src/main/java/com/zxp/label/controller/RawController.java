package com.zxp.label.controller;

import com.zxp.label.Dto.Sentence;
import com.zxp.label.entity.RawSentence;
import com.zxp.label.service.NovelService;
import com.zxp.label.service.RawSentenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "sentence", description = "任务一")
@RequestMapping("raw")
public class RawController {

    @Autowired
    private RawSentenceService rawSentenceService;

    @Autowired
    private NovelService novelService;

    @ApiOperation(value="获取下一个标记句子",  httpMethod = "POST")
    @RequestMapping(value = "/getSentence", method = RequestMethod.POST)
    public Sentence getOne(@RequestParam boolean nextNovel) {
        return novelService.getNovelOrSentence(nextNovel);
    }
}
