package ir.iran.integration.cri.application.port.out.model.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InquiryCmd {
    private String api;
    private UserInputData userInputData;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInputData {
        private RootData root;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RootData {
        private String nationalNumberIn;
        private String birthDateIn;
        private String statusIn;
    }
}