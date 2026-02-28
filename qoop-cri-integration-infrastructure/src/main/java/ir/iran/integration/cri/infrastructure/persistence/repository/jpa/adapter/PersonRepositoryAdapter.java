package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.adapter;

import ir.iran.integration.cri.domain.model.domain.Person;
import ir.iran.integration.cri.domain.model.view.CriProfileView;
import ir.iran.integration.cri.domain.repository.jpa.PersonRepository;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.entity.PersonEntity;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.mapper.CriProfileMapper;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.mapper.PersonMapper;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.spring.PersonJpaRepository;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Registered
@RequiredArgsConstructor
public class PersonRepositoryAdapter implements PersonRepository {

    private final PersonJpaRepository repository;
    private final PersonMapper personMapper;
    private final CriProfileMapper criProfilemapper;

    @Override
    public Person save(Person domain) {
        PersonEntity entity = personMapper.toTarget(domain);
        entity = repository.save(entity);
        return personMapper.toSource(entity);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personMapper.toSource(repository.findById(id));
    }

    @Override
    public Boolean existById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void delete(Person domain) {
        repository.delete(personMapper.toTarget(domain));
    }

    @Override
    public Optional<CriProfileView> findByIdentificationNoAndBirthDate(String identificationNo, Date birthDate) {
        return criProfilemapper.toSource(repository.findByIdentificationNoAndBirthDate(identificationNo, birthDate));
    }
}
