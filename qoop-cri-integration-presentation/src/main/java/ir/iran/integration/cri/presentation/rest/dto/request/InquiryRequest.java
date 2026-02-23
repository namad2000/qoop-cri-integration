package ir.iran.integration.cri.presentation.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InquiryRequest {

    @JsonProperty("api")
    private String api;

    @JsonProperty("userinputdata")
    private UserInputData userInputData;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInputData {

        @JsonProperty("ROOT")
        private RootData root;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RootData {

        @JsonProperty("NATIONALNUMBER_IN")
        private String nationalNumberIn;

        @JsonProperty("BIRTHDATE_IN")
        private String birthDateIn;

        @JsonProperty("STATUS_IN")
        private String statusIn;
    }
}