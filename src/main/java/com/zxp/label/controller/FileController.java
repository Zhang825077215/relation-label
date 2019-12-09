package com.zxp.label.controller;

import com.zxp.label.Dto.MyResponseBody;

import com.zxp.label.service.UploadService;
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
}
