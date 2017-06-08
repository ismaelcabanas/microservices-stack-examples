package cabanas.garcia.ismael.msreverse.framework.controller;

import cabanas.garcia.ismael.msreverse.domain.service.ReverseService;
import cabanas.garcia.ismael.msreverse.framework.controller.apidocs.ReverseApiDocumentation;
import cabanas.garcia.ismael.msreverse.framework.controller.dto.ReverseRequestDTO;
import cabanas.garcia.ismael.msreverse.framework.controller.dto.ReverseResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ismaelcabanas on 8/6/17.
 */
@RestController
public class ReverseController implements ReverseApiDocumentation {

    private static Logger LOGGER = LoggerFactory.getLogger(ReverseController.class);

    @Autowired
    private ReverseService reverseService;

    @RequestMapping(value = "/reverse", method = RequestMethod.POST)
    public ResponseEntity<ReverseResponseDTO> reverse(@RequestBody(required = true) ReverseRequestDTO request) {

        LOGGER.debug("Reversing string '{}'", request.getStringToReverse());

        String reversed = reverseService.reverse(request.getStringToReverse());

        ReverseResponseDTO response = ReverseResponseDTO.Builder.getBuilder().withStringReversed(reversed).build();

        return ResponseEntity.ok(response);
    }
}
