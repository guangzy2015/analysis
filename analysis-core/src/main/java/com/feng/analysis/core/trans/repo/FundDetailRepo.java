package com.feng.analysis.core.trans.repo;

import com.feng.analysis.core.trans.model.FundDetail;

import java.util.List;

public interface FundDetailRepo {
    int batchInsert(List<FundDetail> fundDetails);
}
