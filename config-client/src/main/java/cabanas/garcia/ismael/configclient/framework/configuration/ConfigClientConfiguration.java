package cabanas.garcia.ismael.configclient.framework.configuration;

import cabanas.garcia.ismael.configclient.framework.service.HotMessage;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ismaelcabanas on 7/6/17.
 */
@Configuration
public class ConfigClientConfiguration {

    @RefreshScope
    @Bean
    public HotMessage hotMessage(){
        return new HotMessage();
    }
}
