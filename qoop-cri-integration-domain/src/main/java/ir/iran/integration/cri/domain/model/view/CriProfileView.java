package ir.iran.integration.cri.domain.model.view;

import java.util.Date;

public record CriProfileView(
        // --- Fields from PersonEntity ---
        Long id,
        String code,
        String displayName,
        String identificationNo,

        Long idNumber,
        String idSeri,
        Long idSerial,
        String gender,
        Long zipCode,
        String shabaCode,

        Long pdmid,
        Integer isVerified,
        Date verificationDate,
        Date deathDate,

        String systemError,
        String systemPersianError,
        String sabtError,
        String sabtPersianError,
        String sabtException,
        String sabtPersianException,

        // --- Fields from RealPersonEntity ---
        String firstName,
        String lastName,
        String fatherName,
        Date birthDate,
        String firstNameEn,
        String lastNameEn,
        String socialSecurityNo,
        String passportNo,

        // --- Fields from ContactInfoEntity ---
        String telephone,
        String cellPhone,
        String postCode,
        String fax,
        String email,
        String address,
        String jobAddress
) {
}