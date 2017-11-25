package com.feng.analysis.core.trans;

import com.alibaba.druid.pool.DruidDataSource;
import com.feng.analysis.conf.SpringBootVFS;
import com.feng.analysis.core.db.DBProperties;
import com.google.common.base.Preconditions;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static com.feng.analysis.core.trans.TransDBConfig.SESSION_FACTORY_NAME;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.feng.analysis.core.trans.mapper", sqlSessionFactoryRef = SESSION_FACTORY_NAME)
public class TransDBConfig {
    private static final String DB_PROPERTY_CONFIG_NAME = "transDBProperties";

    private static final String DB_PROPERTY_PREFIX = "analysis.db.trans";

    public static final String DATA_SOURCE_NAME = "transDataSource";

    public static final String TRANSACTION_MANAGER_NAME = "transTx";

    public static final String SESSION_FACTORY_NAME = "transSqlSessionFactory";
    public static final String JDBC_TEMPLATE_NAME = "transJdbcTemplate";

    @Bean(DB_PROPERTY_CONFIG_NAME)
    @ConfigurationProperties(DB_PROPERTY_PREFIX)
    public DBProperties transDBProperties() {
        return new DBProperties();
    }

    @Autowired
    @Bean(DATA_SOURCE_NAME)
    @Qualifier(DATA_SOURCE_NAME)
    @Primary
    public DataSource dataSource(@Qualifier(DB_PROPERTY_CONFIG_NAME) DBProperties dbProperties) {
        Preconditions.checkNotNull(dbProperties.getUrls());
        Preconditions.checkArgument(dbProperties.getUrls().size() > 0);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dbProperties.getDriverClassName());
        dataSource.setUrl(dbProperties.getUrls().get(0));
        dataSource.setUsername(dbProperties.getUserName());
        dataSource.setPassword(dbProperties.getPassword());
        dataSource.setMaxActive(dbProperties.getMaxActive());
        dataSource.setMinIdle(dbProperties.getMinIdle());
        dataSource.setInitialSize(dbProperties.getInitialSize());
        dataSource.setMaxWait(dbProperties.getMaxWait());
        dataSource.setValidationQuery(dbProperties.getValidationQuery());
        dataSource.setTestWhileIdle(dbProperties.getTestWhileIdle());
        dataSource.setTestOnReturn(dbProperties.getTestOnReturn());
        dataSource.setTimeBetweenEvictionRunsMillis(dbProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(dbProperties.getMinEvictableIdleTimeMillis());
        return dataSource;
    }

    @Bean(TRANSACTION_MANAGER_NAME)
    @Qualifier(TRANSACTION_MANAGER_NAME)
    public PlatformTransactionManager transTxManager(@Qualifier(DATA_SOURCE_NAME) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = SESSION_FACTORY_NAME)
    @Qualifier(SESSION_FACTORY_NAME)
    public SqlSessionFactory transSqlSessionFactory(@Qualifier(DATA_SOURCE_NAME) DataSource transDataSource) throws Exception {
        VFS.addImplClass(SpringBootVFS.class);//确保TypeAliasesPackage能够被扫描
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(transDataSource);
        sessionFactory.setTypeAliasesPackage("com.feng.analysis.core.trans.entity");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(false);//设置禁用全局mybatis缓存
        sessionFactory.setConfiguration(configuration);
        return sessionFactory.getObject();
    }

    @Bean(JDBC_TEMPLATE_NAME)
    @Qualifier(JDBC_TEMPLATE_NAME)
    public JdbcTemplate transJdbcTemplate(@Qualifier(DATA_SOURCE_NAME) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
