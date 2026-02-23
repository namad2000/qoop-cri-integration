package ir.iran.integration.cri.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "TB_REAL_PERSON", schema = "PAYESH_CRM")
public class RealPerson {

    @Id
    @Column(name = "PK_PRS")
    private Long pkPrs;

    @Column(name = "FK_FLK_SEX", nullable = false)
    private Long fkFlkSex;

    @Column(name = "FIRST_NAME", nullable = false, length = 200)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 200)
    private String lastName;

    @Column(name = "FATHER_NAME", length = 200)
    private String fatherName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDate;

    @Column(name = "FK_LOC_BIRTH_LOCATION")
    private Long fkLocBirthLocation;

    @Column(name = "FK_FLK_MARITIAL_STATE")
    private Long fkFlkMaritialState;

    @Column(name = "FK_FLK_MILITARY_STATE")
    private Long fkFlkMilitaryState;

    @Column(name = "FIRST_NAME_EN", length = 200)
    private String firstNameEn;

    @Column(name = "LAST_NAME_EN", length = 200)
    private String lastNameEn;

    @Column(name = "SOCIAL_SECURITY_NO", length = 10)
    private String socialSecurityNo;

    @Column(name = "LOCAL_EMPLOYEE_NO")
    private Long localEmployeeNo;

    @Column(name = "PASSPORT_NO", length = 30)
    private String passportNo;
}