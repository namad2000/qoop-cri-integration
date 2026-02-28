package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.spring;

import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.entity.PersonEntity;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.projection.CriProfileProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {

    @Query("SELECT new ir.iran.integration.cri.domain.model.view.CriProfileView(" +
            "p.id, p.lastId, p.code, p.displayName, p.identificationNo, " +
            "p.registerNo, p.registerYear, p.initials, p.accountingCode, p.displayNameEn, " +
            "p.subCode, p.foreignerId, p.token2, " +
            "p.pdmid, p.isVerified, p.verificationDate, p.deathDate, p.lastUpdateDate, " +
            "rp.firstName, rp.lastName, rp.fatherName, rp.birthDate, " +
            "rp.firstNameEn, rp.lastNameEn, rp.socialSecurityNo, rp.passportNo, " +
            "ci.telephone, ci.cellPhone, ci.postCode, ci.fax, ci.email, " +
            "ci.address, ci.jobAddress, ci.jobTel, ci.postBox" +
            ") " +
            "FROM PersonEntity p " +
            "INNER JOIN RealPersonEntity rp ON p.id = rp.pkPrs " +
            "LEFT JOIN ContactInfoEntity ci ON p.fkCni = ci.id " +
            "WHERE p.identificationNo = :identificationNo " +
            "AND p.id = p.lastId " +
            "AND rp.birthDate = :birthDate")
    Optional<CriProfileProjection> findByIdentificationNoAndBirthDate(@Param("identificationNo") String identificationNo,
                                                                      @Param("birthDate") LocalDate birthDate);
}