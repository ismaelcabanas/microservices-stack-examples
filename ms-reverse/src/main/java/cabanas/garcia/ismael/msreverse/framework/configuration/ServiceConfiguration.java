package cabanas.garcia.ismael.msreverse.framework.configuration;

import cabanas.garcia.ismael.msreverse.domain.service.DefaultReverseService;
import cabanas.garcia.ismael.msreverse.domain.service.ReverseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ismaelcabanas on 8/6/17.
 */
@Configuration
public class ServiceConfiguration {

    @Bean
    public ReverseService reverseService(){
        return new DefaultReverseService();
    }
}
