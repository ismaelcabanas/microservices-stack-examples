package cabanas.garcia.ismael.msreverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by ismaelcabanas on 8/6/17.
 */
@SpringBootApplication(scanBasePackages = {
        "cabanas.garcia.ismael.msreverse.framework.configuration",
        "cabanas.garcia.ismael.msreverse.framework.controller"
})
@EnableSwagger2
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args){
        // this property sets a pretty output in actuator metrics
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        SpringApplication.run(Application.class, args);
    }
}
