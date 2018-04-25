package com.feng.analysis.core.trans.service;

import com.feng.analysis.core.trans.model.FundDetail;

import java.util.List;

public interface FundDetailService {
    boolean batchInsert(List<FundDetail> fundDetails);
}
