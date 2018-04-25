package com.feng.analysis.core.trans.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Setter
@Getter
public class FundDetail {
    private Integer id;

    /**
     * 币种
     */
    private String currency;

    /**
     * 证券名称
     */
    private String fundName;

    /**
     * 成交日期
     */
    private String transDate;

    /**
     * 成交价格
     */
    private BigDecimal transPrice;

    /**
     * 成交数量
     */
    private BigDecimal transNumber;

    /**
     * 发生金额
     */
    private BigDecimal transAmount;

    /**
     * 资金余额
     */
    private BigDecimal balance;

    /**
     * 合同编号
     */
    private String contractId;

    /**
     * 业务名称
     */
    private String transDesc;

    /**
     * 手续费
     */
    private BigDecimal transFee;

    /**
     * 印花税
     */
    private BigDecimal stampTax;

    /**
     * 过户费
     */
    private BigDecimal transferFee;

    /**
     * 结算费
     */
    private BigDecimal settleFee;

    /**
     * 证券代码
     */
    private String fundCode;

    /**
     * 股东代码
     */
    private String memberCode;

    private String extension;
}
