package cabanas.garcia.ismael.consumer.framework.controller.dto;

/**
 * Created by ismaelcabanas on 9/6/17.
 */
public class ReverseConsumerResponseDTO {
    private String result;


    public String getResult() {
        return result;
    }

    public static final class ReverseConsumerResponseDTOBuilder {
        private String result;

        private ReverseConsumerResponseDTOBuilder() {
        }

        public static ReverseConsumerResponseDTOBuilder builder() {
            return new ReverseConsumerResponseDTOBuilder();
        }

        public ReverseConsumerResponseDTOBuilder withResult(String result) {
            this.result = result;
            return this;
        }

        public ReverseConsumerResponseDTO build() {
            ReverseConsumerResponseDTO reverseConsumerResponseDTO = new ReverseConsumerResponseDTO();
            reverseConsumerResponseDTO.result = this.result;
            return reverseConsumerResponseDTO;
        }
    }
}
