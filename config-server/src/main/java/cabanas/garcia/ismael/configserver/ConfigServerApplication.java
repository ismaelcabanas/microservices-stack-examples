package cabanas.garcia.ismael.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by ismaelcabanas on 6/6/17.
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args){
        // this property sets a pretty output in actuator metrics
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
