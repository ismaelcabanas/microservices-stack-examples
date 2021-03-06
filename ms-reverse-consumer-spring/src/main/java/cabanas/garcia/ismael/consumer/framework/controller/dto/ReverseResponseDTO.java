package cabanas.garcia.ismael.consumer.framework.controller.dto;

/**
 * Created by ismaelcabanas on 8/6/17.
 */
public class ReverseResponseDTO {

    private String stringReversed;

    private ReverseResponseDTO(){}

    public static final class Builder {
        private String stringReversed;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withStringReversed(String stringReversed) {
            this.stringReversed = stringReversed;
            return this;
        }

        public ReverseResponseDTO build() {
            ReverseResponseDTO reverseResponseDTO = new ReverseResponseDTO();
            reverseResponseDTO.stringReversed = this.stringReversed;
            return reverseResponseDTO;
        }
    }

    public String getStringReversed() {
        return stringReversed;
    }
}
