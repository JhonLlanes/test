package ec.llanes.objrestdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetalles())
                .select()
                .apis(RequestHandlerSelectors.any()).
                paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetalles() {
        return new ApiInfo("Spring boot api rest",
                "libreiras ",
                "1.0",
                "https://localhost",
                new Contact("JOHN LLANES","http://localhost","jlc_rb@live.com"),
                "123123",
                "12313",
                Collections.emptyList());
    }
}
