package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.projection;

import java.util.Date;

public interface CriProfileProjection {

    // --- Fields from PersonEntity ---
    Long getId();

    Long getLastId();

    String getCode();

    String getDisplayName();

    String getIdentificationNo();

    String getRegisterNo();

    Integer getRegisterYear();

    String getInitials();

    String getAccountingCode();

    String getDisplayNameEn();

    String getSubCode();

    String getForeignerId();

    String getToken2();

    Long getPdmid();

    Integer getIsVerified();

    Date getVerificationDate();

    Date getDeathDate();

    Date getLastUpdateDate();

    // --- Fields from RealPersonEntity ---
    String getFirstName();

    String getLastName();

    String getFatherName();

    Date getBirthDate();

    String getFirstNameEn();

    String getLastNameEn();

    String getSocialSecurityNo();

    String getPassportNo();

    // --- Fields from ContactInfoEntity ---
    String getTelephone();

    String getCellPhone();

    String getPostCode();

    String getFax();

    String getEmail();

    String getAddress();

    String getJobAddress();

    String getJobTel();

    String getPostBox();
}