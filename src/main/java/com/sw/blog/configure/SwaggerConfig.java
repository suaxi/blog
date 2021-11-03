package com.sw.blog.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @description
 * @author suaxi
 * @date 2021/10/28 11:16
 */
@Configuration
@Profile({"dev"})
public class SwaggerConfig {

    @Bean
    public Docket defaultApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sw.blog"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "blog",
                "blog with SpringBoot and Layui",
                "1.0.0-SNAPSHOT",
                null,
                new Contact("suaxi", "https://www.wangchouchou.com", "demo@qq.com"),
                "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0.html", Collections.emptyList()
        );
    }
}
