package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "TB_CONTACT_INFO", schema = "PAYESH_CRM")
public class ContactInfoEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TELEPHONE", length = 100)
    private String telephone;

    @Column(name = "CELL_PHONE", length = 11)
    private String cellPhone;

    @Column(name = "POST_CODE", length = 11)
    private String postCode;

    @Column(name = "FAX", length = 50)
    private String fax;

    @Column(name = "POST_BOX", length = 15)
    private String postBox;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "JOB_TEL", length = 100)
    private String jobTel;

    @Column(name = "ADDRESS", length = 2000)
    private String address;

    @Column(name = "JOB_ADDRESS", length = 1000)
    private String jobAddress;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private Date lastUpdateDate;

    @Column(name = "FK_FLK_CONFIRMATION_TYPE")
    private Long fkFlkConfirmationType;

    @Column(name = "FK_LOC_CITY")
    private Long fkLocCity;

    @Column(name = "FK_LOC_PROVINCE")
    private Long fkLocProvince;
}