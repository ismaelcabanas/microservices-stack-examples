package cabanas.garcia.ismael.configclient.framework.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by ismaelcabanas on 7/6/17.
 */
@ConfigurationProperties(prefix="sample.hot")
public class HotMessage {

    private String message;

    public String message(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
