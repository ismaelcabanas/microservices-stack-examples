package cabanas.garcia.ismael.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by ismaelcabanas on 12/6/17.
 */
@SpringBootApplication
@EnableHystrixDashboard
//@EnableTurbine
public class HystrixDashboardApplication {

    public static void main(String[] args){
        // this property sets a pretty output in actuator metrics
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
