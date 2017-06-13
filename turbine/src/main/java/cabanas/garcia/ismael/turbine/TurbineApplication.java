package cabanas.garcia.ismael.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApplication {
    public static void main(String[] args){
        // this property sets a pretty output in actuator metrics
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        SpringApplication.run(TurbineApplication.class, args);
    }
}
