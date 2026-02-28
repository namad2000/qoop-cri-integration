package ir.iran.integration.cri.domain.model.domain;

import ir.iran.integration.cri.domain.enums.DISCRIMINATOR;
import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private Long id;
    private Long lastId;
    private DISCRIMINATOR discriminator;
    private Long fkFlkPersonState;
    private Integer isActive;
    private String code;
    private String displayName;
    private String identificationNo;
    private String registerNo;
    private Integer registerYear;
    private Long fkLocRegisterLocation;
    private Long fkCni;
    private String initials;
    private String accountingCode;
    private Long fkPrsOld;
    private String displayNameEn;
    private Long fkLocNationality;
    private Integer token;
    private Integer isVerified;
    private Long pdmid;
    private Date verificationDate;
    private Date deathDate;
    private Date lastUpdateDate;
    private Long fkCrpParent;
    private String subCode;
    private String foreignerId;
    private String token2;
}