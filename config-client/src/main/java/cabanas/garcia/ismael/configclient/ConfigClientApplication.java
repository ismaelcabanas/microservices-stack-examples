package cabanas.garcia.ismael.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ismaelcabanas on 6/6/17.
 */
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args){
        // this property sets a pretty output in actuator metrics
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
