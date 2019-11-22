package com.zxp.label.controller;

import com.zxp.label.Dto.Label;
import com.zxp.label.Dto.NameInfo;
import com.zxp.label.Dto.ResponseBody;
import com.zxp.label.Dto.Sentence;

import com.zxp.label.service.SentenceService;
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

    @ApiOperation(value="获取下一个标记句子",  httpMethod = "POST")
    //@ApiImplicitParam(name = "nameInfo", value = "用户信息", required = true, dataType = "NameInfo")
    @RequestMapping(value = "/getSentence", method = RequestMethod.POST)
    public ResponseBody getOne(@RequestBody NameInfo nameInfo) {
        ResponseBody responseBody = new ResponseBody();
        try{
            Sentence sentence =  SentenceService.getNovelOrSentence(nameInfo);
            responseBody.setData(sentence).setInfo("查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            responseBody.setInfo(e.getMessage()).setCode(ResponseBody.SYSTEMERROR);
        }
        return responseBody;
    }

    @ApiOperation(value="提交标记",  httpMethod = "POST")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseBody addLabel(@RequestBody Label label) {
        ResponseBody responseBody = new ResponseBody();
        try{
            int time =  usefulSentenceService.insertUsefulSen(label);
            responseBody.setData(time).setInfo("提交成功！");

        } catch (Exception e) {
            e.printStackTrace();
            responseBody.setInfo(e.getMessage()).setCode(ResponseBody.SYSTEMERROR);
        }
        return responseBody;
    }
}
