package com.feng.analysis.app.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动App之后，可直接访问http://localhost:8080/swagger-ui.html 测试接口
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.feng.analysis.app.controller"})
public class ServerSwaggerConfig {
    @Value("${spring.application.name:application}")
    private String appName;

    @Bean
    public Docket categoryApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("all").pathProvider(new AbstractPathProvider() {
            protected String applicationPath() {
                return "/";
            }

            protected String getDocumentationPath() {
                return "/";
            }
        }).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Analysis " + appName + " All API").build();
    }
}
