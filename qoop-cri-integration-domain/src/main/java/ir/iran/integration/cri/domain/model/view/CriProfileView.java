package ir.iran.integration.cri.domain.model.view;

import java.time.LocalDate;

public record CriProfileView(
        // --- Fields from PersonEntity ---
        Long id,
        Long lastId,
        String code,
        String displayName,
        String identificationNo,
        String registerNo,
        Integer registerYear,
        String initials,
        String accountingCode,
        String displayNameEn,
        String subCode,
        String foreignerId,
        String token2,
        Long pdmid,
        Integer isVerified,
        LocalDate verificationDate,
        LocalDate deathDate,
        LocalDate lastUpdateDate,

        // --- Fields from RealPersonEntity ---
        String firstName,
        String lastName,
        String fatherName,
        LocalDate birthDate,
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
        String jobAddress,
        String jobTel,
        String postBox
) {
}