package com.sonatype.interview.config;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${info.build.version}")
  private String version;

  @Bean
  public Docket api() {
    Docket docket = new Docket(DocumentationType.SWAGGER_2) //
        .apiInfo(newApiInfo()) //
        .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) //
        .paths(PathSelectors.any()) //
        .build();

    return docket;
  }

  private ApiInfo newApiInfo() {
    Contact contact = null;
    return new ApiInfo(format("Sonatype API BUILD (%s)", version), //
        "The backend services for Sonatype Interview app.", //
        version, //
        null, //
        contact, //
        "Apache 2.0", //
        "http://www.apache.org/licenses/LICENSE-2.0" //
    );
  }
}
