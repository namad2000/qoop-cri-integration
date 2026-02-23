package ir.iran.integration.cri.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class RealPerson {
    private Long pkPrs;
    private Long fkFlkSex;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Date birthDate;
    private Long fkLocBirthLocation;
    private Long fkFlkMaritialState;
    private Long fkFlkMilitaryState;
    private String firstNameEn;
    private String lastNameEn;
    private String socialSecurityNo;
    private Long localEmployeeNo;
    private String passportNo;
}