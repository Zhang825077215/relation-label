package com.zxp.label.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello")
public class HelloController {

    @ApiOperation(value="输出问候信息",notes="hellow world")
    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    @ApiImplicitParam(name="users", value="姓名", required = true,dataType = "String",paramType = "query")
    public String index(@RequestParam("users") String name) throws Exception{
        return new String("张小飘发生了错误");

        //return "hello world " + name;
    }

}
