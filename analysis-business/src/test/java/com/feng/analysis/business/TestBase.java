package com.feng.analysis.business;

import com.feng.analysis.core.trans.TransDBConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ComponentScan("com.feng.analysis")
@PropertySource({"classpath:db.test.properties"})
@Import(value = {TransDBConfig.class})
@EnableConfigurationProperties
public abstract class TestBase extends AbstractTestNGSpringContextTests {

}
