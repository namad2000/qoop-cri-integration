package ir.iran.integration.cri.domain.model.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContactInfo {
    private Long id;
    private String telephone;
    private String cellPhone;
    private String postCode;
    private String fax;
    private String postBox;
    private String email;
    private String jobTel;
    private String address;
    private String jobAddress;
    private LocalDate lastUpdateDate;
    private Long fkFlkConfirmationType;
    private Long fkLocCity;
    private Long fkLocProvince;
}