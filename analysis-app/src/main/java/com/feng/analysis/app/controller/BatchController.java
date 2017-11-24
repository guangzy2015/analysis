package com.feng.analysis.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "日终Job查询api")
@RestController
public class BatchController {

    @ApiOperation(value = "测试API")
    @RequestMapping(value = "/batches/{closingDate}", method = {RequestMethod.GET})
    public String getBatchStatus(@PathVariable("closingDate") String closingDate) {
        return  "SUCCESS";
    }
}
