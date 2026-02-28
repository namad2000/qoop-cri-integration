package ir.iran.integration.cri.domain.repository.jpa;

import io.qoop.domain.repository.DomainRepository;
import ir.iran.integration.cri.domain.model.domain.Person;
import ir.iran.integration.cri.domain.model.view.CriProfileView;

import java.util.Date;
import java.util.Optional;

public interface PersonRepository extends DomainRepository<Person, Long> {
    Optional<CriProfileView> findByIdentificationNoAndBirthDate(String identificationNo, Date birthDate);
}
