package com.feng.analysis.business.trans.impl;

import com.feng.analysis.business.trans.FundDetailProcessor;
import com.feng.analysis.common.util.FileUtil;
import com.feng.analysis.common.util.NumberUtil;
import com.feng.analysis.core.trans.model.FundDetail;
import com.feng.analysis.core.trans.service.FundDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.feng.analysis.common.constants.FundDetailFieldInfo.*;

@Component
public class FundDetailProcessorImpl implements FundDetailProcessor {
    @Autowired
    FundDetailService fundDetailService;

    @Override
    public boolean parseAndSaveFundDetailFromFile(String fileName) {
        List<FundDetail> fundDetails = new ArrayList<FundDetail>();
        List<String> fileContent = FileUtil.readFile(fileName);
        for (String fileLineMsg : fileContent) {
            if (StringUtils.isNoneBlank(fileLineMsg)) {
                fundDetails.add(parseFileLine(fileLineMsg));
            }
        }

        return fundDetailService.batchInsert(fundDetails);
    }

    private FundDetail parseFileLine(String fileLineMsg) {
        FundDetail fundDetail = new FundDetail();
        fundDetail.setCurrency(fileLineMsg.substring(CURRENCY_INDEX_START, CURRENCY_INDEX_END).trim());
        fundDetail.setFundName(fileLineMsg.substring(FUND_NAME_INDEX_START, FUND_NAME_INDEX_END).trim());
        fundDetail.setTransDate(fileLineMsg.substring(TRANS_DATE_INDEX_START, TRANS_DATE_INDEX_END).trim());
        fundDetail.setTransPrice(NumberUtil.getValue(fileLineMsg.substring(TRANS_PRICE_INDEX_START, TRANS_PRICE_INDEX_END).trim()));
        fundDetail.setTransNumber(NumberUtil.getValue(fileLineMsg.substring(TRANS_NUMBER_INDEX_START, TRANS_NUMBER_INDEX_END).trim()));
        fundDetail.setTransAmount(NumberUtil.getValue(fileLineMsg.substring(TRANS_AMOUNT_INDEX_START, TRANS_AMOUNT_INDEX_END).trim()));
        fundDetail.setBalance(NumberUtil.getValue(fileLineMsg.substring(BALANCE_INDEX_START, BALANCE_INDEX_END).trim()));
        fundDetail.setContractId(fileLineMsg.substring(CONTRACT_ID_INDEX_START, CONTRACT_ID_INDEX_END).trim());

        String transDesc = getTransDesc(fileLineMsg);
        fundDetail.setTransDesc(transDesc.trim());
        fileLineMsg = fileLineMsg.substring(TRANS_DESC_INDEX_START + transDesc.length());
        fundDetail.setTransFee(NumberUtil.getValue(fileLineMsg.substring(TRANS_FEE_INDEX_START, TRANS_FEE_INDEX_END).trim()));
        fundDetail.setStampTax(NumberUtil.getValue(fileLineMsg.substring(STAMP_TAX_INDEX_START, STAMP_TAX_INDEX_END).trim()));
        fundDetail.setTransferFee(NumberUtil.getValue(fileLineMsg.substring(TRANSFER_FEE_INDEX_START, TRANSFER_FEE_INDEX_END).trim()));
        fundDetail.setSettleFee(NumberUtil.getValue(fileLineMsg.substring(SETTLE_FEE_INDEX_START, SETTLE_FEE_INDEX_END).trim()));
        fundDetail.setFundCode(fileLineMsg.substring(FUND_CODE_INDEX_START, FUND_CODE_INDEX_END).trim());
        fundDetail.setMemberCode(fileLineMsg.substring(MEMBER_CODE_INDEX_START, MEMBER_CODE_INDEX_END).trim());
        return fundDetail;
    }

    private String getTransDesc(String fileLineMsg) {
        String remainMsg = fileLineMsg.substring(TRANS_DESC_INDEX_START);
        if (remainMsg.indexOf('-') > 0) {
            return remainMsg.substring(0, remainMsg.indexOf('-'));
        }

        if (remainMsg.lastIndexOf(')') > 0) {
            return remainMsg.substring(0, remainMsg.lastIndexOf(')') + 1);
        }

        return remainMsg.substring(0, 12);
    }

}
