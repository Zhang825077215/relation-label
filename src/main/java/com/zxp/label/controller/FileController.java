package com.zxp.label.controller;

import com.zxp.label.Dto.MyResponseBody;

import com.zxp.label.Dto.UserCount;
import com.zxp.label.service.RawSentenceService;
import com.zxp.label.service.UploadService;
import com.zxp.label.service.UsefulSentenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@Api(value = "data", description = "添加数据")
@RequestMapping(value="/file")
public class FileController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private RawSentenceService rawSentenceService;

    @Autowired
    private UsefulSentenceService usefulSentenceService;


    @ApiOperation(value="插入rawSentence",  httpMethod = "POST")
    @RequestMapping(value = "/addRaw", method = RequestMethod.POST)
    public MyResponseBody loadRaw(@RequestParam("file") MultipartFile file) throws Exception{
        MyResponseBody myResponseBody = new MyResponseBody();
        int count = uploadService.uploadRawSentence(file);
        myResponseBody.setData(count).setInfo("导入Raw成功！");
        return myResponseBody;
    }

    @ApiOperation(value="插入novel",  httpMethod = "POST")
    @RequestMapping(value = "/addNovel", method = RequestMethod.POST)
    public MyResponseBody loadNovel(@RequestParam("file") MultipartFile file) throws Exception{
        MyResponseBody myResponseBody = new MyResponseBody();
        int count = uploadService.uploadnovel(file);
        myResponseBody.setData(count).setInfo("导入Novel成功！");
        return myResponseBody;
    }

    @ApiOperation(value="获取标注进展",  httpMethod = "GET")
    @RequestMapping(value = "/getCount", method = RequestMethod.GET)
    public MyResponseBody getCount() throws Exception{
        MyResponseBody myResponseBody = new MyResponseBody();
        UserCount userCount = new UserCount();
        userCount.setRaw(rawSentenceService.getCountRaw(null))
                .setUseful(usefulSentenceService.getCountUseful(null));
        myResponseBody.setData(userCount).setInfo("查询成功！");
        return myResponseBody;
    }


}
