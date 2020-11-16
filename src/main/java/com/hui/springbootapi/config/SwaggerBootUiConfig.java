package com.hui.springbootapi.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerBootUiConfig配置信息
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerBootUiConfig {
    /**
     * 分组v1
     * @return
     */
    @Bean
    public Docket v1ApiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //swagger 文档扫码的包,也就是控制所在包
                .apis(RequestHandlerSelectors.basePackage("com.hui.springbootapi.controller.v1"))
                .paths(PathSelectors.any())
                .build().groupName("v1");
    }

    /**
     * 分组v2
     * @return
     */
    @Bean
    public Docket v2ApiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //swagger 文档扫码的包,也就是控制所在包
                .apis(RequestHandlerSelectors.basePackage("com.hui.springbootapi.controller.v2"))
                .paths(PathSelectors.any())
                .build().groupName("v2");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui 文档使用")
                .description("集成swagger-bootstrap-ui到SpringBoot")
                .termsOfServiceUrl("http://localhost:8999/")
                .contact("刘庆辉")
                .version("1.0")
                .build();
    }
}
