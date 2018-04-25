package com.feng.analysis.common.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

import static com.feng.analysis.common.constants.FieldConstants.BLACK_FIELD_VALUE;

public class NumberUtil {
    private NumberUtil() {
    }

    public static BigDecimal getValue(String strValue) {
        if (StringUtils.isBlank(strValue) || BLACK_FIELD_VALUE.equals(strValue)) {
            return BigDecimal.ZERO.setScale(2);
        }

        return new BigDecimal(strValue);
    }
}
