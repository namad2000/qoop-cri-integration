package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.spring;

import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.entity.PersonEntity;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.projection.CriProfileProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {

    @Query("SELECT p FROM PersonEntity p " +
            "INNER JOIN RealPersonEntity rp ON p.id = rp.pkPrs " +
            "LEFT JOIN ContactInfoEntity ci ON p.fkCni = ci.id " +
            "WHERE p.identificationNo = :identificationNo " +
            "AND rp.birthDate = :birthDate")
    Optional<CriProfileProjection> findByIdentificationNoAndBirthDate(@Param("identificationNo") String identificationNo,
                                                                      @Param("birthDate") Date birthDate);
}