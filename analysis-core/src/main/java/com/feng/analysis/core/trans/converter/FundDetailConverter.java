package com.feng.analysis.core.trans.converter;

import com.feng.analysis.core.trans.entity.FundDetailEntity;
import com.feng.analysis.core.trans.model.FundDetail;

public class FundDetailConverter {
    public static FundDetail getModel(FundDetailEntity entity) {
        FundDetail fundDetail = new FundDetail();
        fundDetail.setId(entity.getId());
        fundDetail.setCurrency(entity.getCurrency());
        fundDetail.setFundName(entity.getFundName());
        fundDetail.setTransDate(entity.getTransDate());
        fundDetail.setTransPrice(entity.getTransPrice());
        fundDetail.setTransNumber(entity.getTransNumber());
        fundDetail.setTransAmount(entity.getTransAmount());
        fundDetail.setBalance(entity.getBalance());
        fundDetail.setContractId(entity.getContractId());
        fundDetail.setTransDesc(entity.getTransDesc());
        fundDetail.setTransFee(entity.getTransFee());
        fundDetail.setStampTax(entity.getStampTax());
        fundDetail.setTransferFee(entity.getTransferFee());
        fundDetail.setFundCode(entity.getFundCode());
        fundDetail.setMemberCode(entity.getMemberCode());
        fundDetail.setExtension(entity.getExtension());

        return fundDetail;
    }

    public static FundDetailEntity getEntity(FundDetail model) {
        FundDetailEntity entity = new FundDetailEntity();
        entity.setId(model.getId());
        entity.setCurrency(model.getCurrency());
        entity.setFundName(model.getFundName());
        entity.setTransDate(model.getTransDate());
        entity.setTransPrice(model.getTransPrice());
        entity.setTransNumber(model.getTransNumber());
        entity.setTransAmount(model.getTransAmount());
        entity.setBalance(model.getBalance());
        entity.setContractId(model.getContractId());
        entity.setTransDesc(model.getTransDesc());
        entity.setTransFee(model.getTransFee());
        entity.setStampTax(model.getStampTax());
        entity.setTransferFee(model.getTransferFee());
        entity.setFundCode(model.getFundCode());
        entity.setMemberCode(model.getMemberCode());
        entity.setExtension(model.getExtension());

        return entity;
    }
}
