package com.feng.analysis.app.conf;

import java.util.UUID;

public interface LogProperty {
    /**
     * 请求ID的key  请求ID是没有业务含义的，代表一次同步调用的方法的执行
     */
    String REQ_ID = "reqId";

    static String newReqId() {
        return UUID.randomUUID().toString();
    }

    /**
     *业务标识的key  业务标识是有含义的，需要具体的代码手动设置进去
     * @see org.slf4j.MDC
     */
    String BUSINESS_ID = "businessId";

    String businessKey();
}
