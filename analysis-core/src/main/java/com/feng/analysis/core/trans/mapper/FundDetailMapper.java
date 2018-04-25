package com.feng.analysis.core.trans.mapper;

import com.feng.analysis.core.trans.entity.FundDetailEntity;

import java.util.List;

public interface FundDetailMapper {

    int batchInsert(List<FundDetailEntity> entityList);
}
