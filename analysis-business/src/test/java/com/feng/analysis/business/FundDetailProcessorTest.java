package com.feng.analysis.business;

import com.feng.analysis.business.trans.FundDetailProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class FundDetailProcessorTest extends TestBase {

    @Autowired
    FundDetailProcessor processor;

    @Test
    public void testParseAndSave(){
        processor.parseAndSaveFundDetailFromFile("D:\\TestCenter\\analysisFileInput\\20140101-20140630.txt");
        processor.parseAndSaveFundDetailFromFile("D:\\TestCenter\\analysisFileInput\\20140701-20141231.txt");
        processor.parseAndSaveFundDetailFromFile("D:\\TestCenter\\analysisFileInput\\20150101-20150630.txt");
        processor.parseAndSaveFundDetailFromFile("D:\\TestCenter\\analysisFileInput\\20150701-20151231.txt");
        processor.parseAndSaveFundDetailFromFile("D:\\TestCenter\\analysisFileInput\\20160101-20160630.txt");
        processor.parseAndSaveFundDetailFromFile("D:\\TestCenter\\analysisFileInput\\20160701-20161231.txt");
        processor.parseAndSaveFundDetailFromFile("D:\\TestCenter\\analysisFileInput\\20170101-20170630.txt");
        processor.parseAndSaveFundDetailFromFile("D:\\TestCenter\\analysisFileInput\\20170701-20171207.txt");
    }

}
