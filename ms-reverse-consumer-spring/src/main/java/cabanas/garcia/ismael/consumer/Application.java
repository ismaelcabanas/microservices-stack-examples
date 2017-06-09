package cabanas.garcia.ismael.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by ismaelcabanas on 9/6/17.
 */
@SpringBootApplication(scanBasePackages = {
        "cabanas.garcia.ismael.consumer.framework.configuration",
        "cabanas.garcia.ismael.consumer.framework.controller"
})
@EnableSwagger2
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        SpringApplication.run(Application.class, args);
    }

}
