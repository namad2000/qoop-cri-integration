package ir.iran.integration.cri.presentation.rest.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InquiryResponse {

    @JsonProperty("ROOT")
    private RootData root;

    @Data
    @NoArgsConstructor
    public static class RootData {
        @JsonProperty("ROW")
        private RowData row;
    }

    @Data
    @NoArgsConstructor
    public static class RowData {

        @JsonProperty("FNAME_FA")
        private String fnameFa;

        @JsonProperty("FNAME_EN")
        private String fnameEn;

        @JsonProperty("LNAME_FA")
        private String lnameFa;

        @JsonProperty("LNAME_EN")
        private String lnameEn;

        @JsonProperty("FATHER_NAME_FA")
        private String fatherNameFa;

        @JsonProperty("FATHER_NAME_EN")
        private String fatherNameEn;

        @JsonProperty("IDNUMBER")
        private Integer idNumber;

        @JsonProperty("IDSERI")
        private String idSeri;

        @JsonProperty("IDSERIAL")
        private Integer idSerial;

        @JsonProperty("BIRTHDATE")
        private String birthDate;

        @JsonProperty("NATIONAL_NUMBER")
        private Long nationalNumber;

        @JsonProperty("GENDER")
        private String gender;

        @JsonProperty("IS_DEAD")
        private String isDead;

        @JsonProperty("DEATHDATE")
        private String deathDate;

        @JsonProperty("IS_VERIFIED")
        private String isVerified;

        @JsonProperty("VERIFICATION_DATETIME")
        private String verificationDatetime;

        @JsonProperty("INQSTATUS")
        private String inqStatus;

        @JsonProperty("INQDESC")
        private String inqDesc;

        @JsonProperty("SHABA_CODE")
        private String shabaCode;

        @JsonProperty("PDM_ID")
        private Integer pdmId;

        @JsonProperty("ZIPCODE")
        private Long zipCode;

        @JsonProperty("SYSTEMERROR")
        private String systemError;

        @JsonProperty("SYSTEMPERSIANERROR")
        private String systemPersianError;

        @JsonProperty("SABTERROR")
        private String sabtError;

        @JsonProperty("SABTPERSIANERROR")
        private String sabtPersianError;

        @JsonProperty("SABTEXCEPTION")
        private String sabtException;

        @JsonProperty("SABTPERSIANEXCEPTION")
        private String sabtPersianException;
    }
}