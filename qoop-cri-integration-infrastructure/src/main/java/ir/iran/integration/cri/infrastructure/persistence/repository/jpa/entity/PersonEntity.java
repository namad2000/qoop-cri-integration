package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.entity;

import ir.iran.integration.cri.domain.enums.DISCRIMINATOR;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "TB_PERSON", schema = "PAYESH_CRM")
public class PersonEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "LAST_ID", nullable = false)
    private Long lastId;

    @Enumerated(EnumType.STRING)
    @Column(name = "DISCRIMINATOR", nullable = false, length = 4)
    private DISCRIMINATOR discriminator;

    @Column(name = "FK_FLK_PERSON_STATE", nullable = false)
    private Long fkFlkPersonState;

    @Column(name = "IS_ACTIVE")
    private Integer isActive;

    @Column(name = "CODE", nullable = false, length = 30)
    private String code;

    @Column(name = "DISPLAY_NAME", nullable = false, length = 250)
    private String displayName;

    @Column(name = "IDENTIFICATION_NO", length = 11)
    private String identificationNo;

    @Column(name = "REGISTER_NO", length = 25)
    private String registerNo;

    @Column(name = "REGISTER_YEAR")
    private Integer registerYear;

    @Column(name = "FK_LOC_REGISTER_LOCATION")
    private Long fkLocRegisterLocation;

    @Column(name = "FK_CNI")
    private Long fkCni;

    @Column(name = "INITIALS", length = 200)
    private String initials;

    @Column(name = "ACCOUNTING_CODE", length = 11)
    private String accountingCode;

    @Column(name = "FK_PRS_OLD")
    private Long fkPrsOld;

    @Column(name = "DISPLAY_NAME_EN", length = 200)
    private String displayNameEn;

    @Column(name = "FK_LOC_NATIONALITY")
    private Long fkLocNationality;

    @Column(name = "TOKEN")
    private Integer token;

    @Column(name = "IS_VERIFIED")
    private Integer isVerified;

    @Column(name = "PDMID")
    private Long pdmid;

    @Temporal(TemporalType.DATE)
    @Column(name = "VERIFICATION_DATE")
    private Date verificationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DEATH_DATE")
    private Date deathDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private Date lastUpdateDate;

    @Column(name = "FK_CRP_PARENT")
    private Long fkCrpParent;

    @Column(name = "SUB_CODE", length = 10)
    private String subCode;

    @Column(name = "FOREIGNER_ID", length = 30)
    private String foreignerId;

    @Column(name = "TOKEN2", length = 30)
    private String token2;
}