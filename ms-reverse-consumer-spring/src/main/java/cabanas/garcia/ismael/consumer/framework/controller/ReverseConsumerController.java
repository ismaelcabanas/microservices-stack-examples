package cabanas.garcia.ismael.consumer.framework.controller;

import cabanas.garcia.ismael.consumer.framework.controller.apidocs.ReverseConsumerApiDocumentation;
import cabanas.garcia.ismael.consumer.framework.controller.dto.ReverseConsumerRequestDTO;
import cabanas.garcia.ismael.consumer.framework.controller.dto.ReverseConsumerResponseDTO;
import cabanas.garcia.ismael.consumer.framework.controller.dto.ReverseRequestDTO;
import cabanas.garcia.ismael.consumer.framework.controller.dto.ReverseResponseDTO;
import cabanas.garcia.ismael.consumer.framework.controller.service.ReverseClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ismaelcabanas on 9/6/17.
 */
@RestController
public class ReverseConsumerController implements ReverseConsumerApiDocumentation {

    private static Logger LOGGER = LoggerFactory.getLogger(ReverseConsumerController.class);

    private static final String MESSAGE = "The reverse of string %s is %s";

    @Autowired
    private ReverseClient reverseClient;

    @RequestMapping(value = "/consumeReverse", method = RequestMethod.POST)
    public ResponseEntity<ReverseConsumerResponseDTO> consumeReverse(@RequestBody(required = true) ReverseConsumerRequestDTO request) {

        LOGGER.debug("Consuming '{}' for reversing", request.getToReverse());

        ReverseRequestDTO reverseRequest = new ReverseRequestDTO();
        reverseRequest.setStringToReverse(request.getToReverse());
        ReverseResponseDTO reverseResponse = reverseClient.reverse(reverseRequest);

        ReverseConsumerResponseDTO response = ReverseConsumerResponseDTO.ReverseConsumerResponseDTOBuilder.builder()
                .withResult(String.format(MESSAGE, request.getToReverse(), reverseResponse.getStringReversed()))
                .build();

        return ResponseEntity.ok(response);
    }
}
