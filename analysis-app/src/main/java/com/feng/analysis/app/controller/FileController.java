package com.feng.analysis.app.controller;


import com.feng.analysis.business.trans.FundDetailProcessor;
import com.feng.analysis.core.trans.model.FundDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "文件处理api")
@RestController
public class FileController {

    @Autowired
    FundDetailProcessor fundDetailProcessor;

    @ApiOperation(value = "解析并落地资金明细API")
    @RequestMapping(value = "/file/{fileName}", method = {RequestMethod.POST})
    public boolean parseFile(@PathVariable("fileName") String fileName) {
        return fundDetailProcessor.parseAndSaveFundDetailFromFile(fileName);
    }
}
