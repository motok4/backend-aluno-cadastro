package br.ufop.ntifront.ntiFront.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket alunosApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 .apis(RequestHandlerSelectors.basePackage("br.ufop.ntifront.ntiFront.controller"))
                .paths(PathSelectors.regex("/*.*"))
                .build();

    }
//    @Bean
//    public Docket disciplinasApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()                 .apis(RequestHandlerSelectors.basePackage("br.ufop.ntifront.ntiFront.controller"))
//                .paths(PathSelectors.regex("/disciplina.*"))
//                .build();
//
//    }


}