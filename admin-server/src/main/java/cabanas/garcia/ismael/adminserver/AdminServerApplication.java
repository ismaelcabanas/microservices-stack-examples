package cabanas.garcia.ismael.adminserver;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ismaelcabanas on 11/6/17.
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminServerApplication {

    public static void main(String[] args){
        // this property sets a pretty output in actuator metrics
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        SpringApplication.run(AdminServerApplication.class, args);
    }
}
