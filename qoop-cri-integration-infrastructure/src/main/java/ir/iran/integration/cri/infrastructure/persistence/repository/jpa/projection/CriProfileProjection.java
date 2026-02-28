package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.projection;

import java.util.Date;

public interface CriProfileProjection {

    // --- Fields from PersonEntity ---
    Long getId();

    String getCode();

    String getDisplayName();

    String getIdentificationNo();

    Long getIdNumber();

    String getIdSeri();

    Long getIdSerial();

    String getGender();

    Long getZipCode();

    String getShabaCode();

    Long getPdmid();

    Integer getIsVerified();

    Date getVerificationDate();

    Date getDeathDate();

    String getSystemError();

    String getSystemPersianError();

    String getSabtError();

    String getSabtPersianError();

    String getSabtException();

    String getSabtPersianException();

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
}