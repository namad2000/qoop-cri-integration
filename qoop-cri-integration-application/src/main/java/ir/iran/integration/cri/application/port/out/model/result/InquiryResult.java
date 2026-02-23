package ir.iran.integration.cri.application.port.out.model.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InquiryResult {
    private RootData root;

    @Data
    @NoArgsConstructor
    public static class RootData {
        private RowData row;
    }

    @Data
    @NoArgsConstructor
    public static class RowData {
        private String fnameFa;
        private String fnameEn;
        private String lnameFa;
        private String lnameEn;
        private String fatherNameFa;
        private String fatherNameEn;
        private Integer idNumber;
        private String idSeri;
        private Integer idSerial;
        private String birthDate;
        private Long nationalNumber;
        private String gender;
        private String isDead;
        private String deathDate;
        private String isVerified;
        private String verificationDatetime;
        private String inqStatus;
        private String inqDesc;
        private String shabaCode;
        private Integer pdmId;
        private Long zipCode;
        private String systemError;
        private String systemPersianError;
        private String sabtError;
        private String sabtPersianError;
        private String sabtException;
        private String sabtPersianException;
    }
}