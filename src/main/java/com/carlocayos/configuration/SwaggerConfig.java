package com.carlocayos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("swagger")
@EnableSwagger2
public class SwaggerConfig
{
    /**
     * @return
     */
    public Docket dogApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("dog-api")
                .useDefaultResponseMessages(false)
                .apiInfo(buildApiInfo())
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }

    /**
     * @return
     */
    @Bean
    public UiConfiguration uiConfig()
    {
        return new UiConfiguration(null);
    }

    /**
     * @return
     */
    private ApiInfo buildApiInfo()
    {
        return new ApiInfoBuilder()
                .title("Dog API")
                .description("API for managing dogs")
                .version("1.0")
                .build();
    }
}
