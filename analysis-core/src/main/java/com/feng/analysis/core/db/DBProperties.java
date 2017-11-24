package com.feng.analysis.core.db;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * DB属性配置类.
 */
@NoArgsConstructor
@Getter
@Setter
public class DBProperties {

    private List<String> urls = Lists.newArrayList();

    private String userName;

    private String password;

    private int tableCount;

    private String schemaPrefix;

    private String driverClassName;
    /**
     *连接池的最大数据库连接数。设为0表示无限制
     */
    private  int maxActive;
    /**
     *最小空闲连接数
     */
    private int minIdle;
    /**
     初始连接数
     */
    private int initialSize;
    /**
     * 超时等待时间以毫秒为单位
     */
    private long maxWait;
    /**
     *验证从连接池取出的连接
     */
    private String validationQuery;
    /**
     * 是否生效
     */
    private Boolean testWhileIdle;
    /**
     * 指明是否在归还到池中前进行检验
     */
    private Boolean testOnReturn;
    /**
     *  在空闲连接回收器线程运行期间休眠的时间值,以毫秒为单位
     */
    private long timeBetweenEvictionRunsMillis;
    /**
     * #连接在池中保持空闲而不被空闲连接回收器线程
     */
    private long minEvictableIdleTimeMillis;

}