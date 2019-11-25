package com.zxp.label.controller;

import com.zxp.label.Dto.Label;
import com.zxp.label.Dto.NameInfo;
import com.zxp.label.Dto.MyResponseBody;
import com.zxp.label.Dto.Sentence;

import com.zxp.label.service.SentenceService;
import com.zxp.label.service.TypeService;
import com.zxp.label.service.UsefulSentenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "sentence", description = "任务一")
@RequestMapping("raw")
public class RawController {

    @Autowired
    private SentenceService SentenceService;

    @Autowired
    private UsefulSentenceService usefulSentenceService;

    @Autowired
    private TypeService typeService;

    @ApiOperation(value="获取下一个标记句子",  httpMethod = "POST")
    @RequestMapping(value = "/getSentence", method = RequestMethod.POST)
    public MyResponseBody getOne(@RequestBody NameInfo nameInfo) throws Exception{
        MyResponseBody myResponseBody = new MyResponseBody();

        Sentence sentence =  SentenceService.getNovelOrSentence(nameInfo);
        myResponseBody.setData(sentence).setInfo("查询成功！");
        return myResponseBody;
    }

    @ApiOperation(value="提交标记",  httpMethod = "POST")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MyResponseBody addLabel(@RequestBody Label label) throws Exception{
        MyResponseBody myResponseBody = new MyResponseBody();
        int times =  usefulSentenceService.insertUsefulSen(label);
        myResponseBody.setData(times).setInfo("提交成功！");
        return myResponseBody;
    }

    @ApiOperation(value="获取标记类型",  httpMethod = "GET")
    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public MyResponseBody getTypes(@RequestParam String param)  throws Exception{
        MyResponseBody myResponseBody = new MyResponseBody();
        myResponseBody.setData(typeService.getListTypes(param)).setInfo("查询成功！");
        return myResponseBody;
    }
}
