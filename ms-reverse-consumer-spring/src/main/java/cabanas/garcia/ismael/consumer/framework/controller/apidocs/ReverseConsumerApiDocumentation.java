package cabanas.garcia.ismael.consumer.framework.controller.apidocs;

import cabanas.garcia.ismael.consumer.framework.controller.dto.ReverseConsumerRequestDTO;
import cabanas.garcia.ismael.consumer.framework.controller.dto.ReverseConsumerResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

/**
 * Created by ismaelcabanas on 9/6/17.
 */
public interface ReverseConsumerApiDocumentation {

    @ApiOperation(value = "reverse-consumeReverse", nickname = "reverse-consumeReverse", response = ReverseConsumerResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    ResponseEntity<ReverseConsumerResponseDTO> consumeReverse(@ApiParam(value = "request", required = true) ReverseConsumerRequestDTO request);

}
