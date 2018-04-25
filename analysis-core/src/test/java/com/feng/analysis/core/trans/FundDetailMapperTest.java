package com.feng.analysis.core.trans;

import com.feng.analysis.core.TestBase;
import com.feng.analysis.core.trans.entity.FundDetailEntity;
import com.feng.analysis.core.trans.mapper.FundDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FundDetailMapperTest extends TestBase {
    @Autowired
    FundDetailMapper mapper;

    @Test
    public void testBatchInsert(){
        List<FundDetailEntity> list = new ArrayList<>();
        FundDetailEntity entity1 = new FundDetailEntity();
        entity1.setCurrency("CNY");
        entity1.setFundName("Test");
        entity1.setTransDate("20171125");
        entity1.setTransPrice(new BigDecimal(2.00));
        entity1.setTransNumber(new BigDecimal(3000.00));
        entity1.setTransAmount(new BigDecimal(6000.00));
        entity1.setBalance(new BigDecimal(6000.00));
        entity1.setContractId("123456789");
        entity1.setTransDesc("测试");
        entity1.setTransFee(new BigDecimal(6.00));
        entity1.setStampTax(new BigDecimal(1.23));
        entity1.setTransferFee(new BigDecimal(1.50));
        entity1.setSettleFee(new BigDecimal(0.00));
        entity1.setFundCode("601001");
        entity1.setMemberCode("0698151591");
        entity1.setExtension("{}");

        FundDetailEntity entity2 = new FundDetailEntity();
        entity2.setCurrency("CNY");
        entity2.setFundName("Test");
        entity2.setTransDate("20171125");
        entity2.setTransPrice(new BigDecimal(1.20));
        entity2.setTransNumber(new BigDecimal(1000.00));
        entity2.setTransAmount(new BigDecimal(1200.00));
        entity2.setBalance(new BigDecimal(1200.00));
        entity2.setContractId("2313671999");
        entity2.setTransDesc("测试");
        entity2.setTransFee(new BigDecimal(7.00));
        entity2.setStampTax(new BigDecimal(2.23));
        entity2.setTransferFee(new BigDecimal(2.50));
        entity2.setSettleFee(new BigDecimal(1.25));
        entity2.setFundCode("601002");
        entity2.setMemberCode("0698151591");
        entity2.setExtension("{}");

        list.add(entity1);
        list.add(entity2);

        mapper.batchInsert(list);
    }
}
