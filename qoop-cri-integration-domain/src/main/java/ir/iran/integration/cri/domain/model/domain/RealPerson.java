package ir.iran.integration.cri.domain.model.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RealPerson {
    private Long pkPrs;
    private Long fkFlkSex;
    private String firstName;
    private String lastName;
    private String fatherName;
    private LocalDate birthDate;
    private Long fkLocBirthLocation;
    private Long fkFlkMaritialState;
    private Long fkFlkMilitaryState;
    private String firstNameEn;
    private String lastNameEn;
    private String socialSecurityNo;
    private Long localEmployeeNo;
    private String passportNo;
}