package com.feng.analysis.core.trans.service.impl;

import com.feng.analysis.core.trans.model.FundDetail;
import com.feng.analysis.core.trans.repo.FundDetailRepo;
import com.feng.analysis.core.trans.service.FundDetailService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundDetailServiceImpl implements FundDetailService {
    @Autowired
    FundDetailRepo fundDetailRepo;

    @Override
    public boolean batchInsert(List<FundDetail> fundDetails) {
        Preconditions.checkNotNull(fundDetails, "fundDetails can not be null.");
        Preconditions.checkArgument(fundDetails.size() > 0);

        return fundDetailRepo.batchInsert(fundDetails) == fundDetails.size();
    }
}
