package com.feng.analysis.core.trans.repo.impl;

import com.feng.analysis.core.trans.converter.FundDetailConverter;
import com.feng.analysis.core.trans.mapper.FundDetailMapper;
import com.feng.analysis.core.trans.model.FundDetail;
import com.feng.analysis.core.trans.repo.FundDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FundDetailRepoImpl implements FundDetailRepo {
    @Autowired
    FundDetailMapper mapper;

    @Override
    public int batchInsert(List<FundDetail> fundDetails) {
        return mapper.batchInsert(fundDetails.stream().map(FundDetailConverter::getEntity).collect(Collectors.toList()));
    }
}
