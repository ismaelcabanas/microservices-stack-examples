package cabanas.garcia.ismael.consumer.framework.controller.service;

import cabanas.garcia.ismael.consumer.framework.controller.dto.ReverseRequestDTO;
import cabanas.garcia.ismael.consumer.framework.controller.dto.ReverseResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ismaelcabanas on 9/6/17.
 */
@ConfigurationProperties(prefix="ms.reverse")
public class ReverseClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReverseClient.class);

    @Autowired
    private RestTemplate restTemplate;

    private String endpoint;

    public ReverseResponseDTO reverse(ReverseRequestDTO reverseRequest){

        LOGGER.debug("Endpoint {}", endpoint);

        return restTemplate.postForObject(endpoint, reverseRequest, ReverseResponseDTO.class);

    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
