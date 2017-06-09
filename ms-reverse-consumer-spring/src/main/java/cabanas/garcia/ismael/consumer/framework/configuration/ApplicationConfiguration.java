package cabanas.garcia.ismael.consumer.framework.configuration;

import cabanas.garcia.ismael.consumer.framework.controller.service.ReverseClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ismaelcabanas on 9/6/17.
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public ReverseClient reverseClient(){
        return new ReverseClient();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
