package ir.iran.integration.cri.domain.service;


import io.qoop.fault.handler.api.exception.DomainBusinessException;
import io.qoop.filter.bean.api.DomainService;
import ir.iran.integration.cri.domain.model.view.CriProfileView;
import ir.iran.integration.cri.domain.repository.jpa.PersonRepository;

import java.time.LocalDate;

import static ir.iran.integration.cri.domain.exception.PersonExceptionCode.PERSON_NOT_FOUND;

@DomainService
public record PersonService(PersonRepository personRepository) {

    public CriProfileView findByIdentificationNoAndBirthDate(String identificationNo, LocalDate birthDate) {
        return personRepository.findByIdentificationNoAndBirthDate(identificationNo, birthDate)
                .orElseThrow(() -> DomainBusinessException.withParams(PERSON_NOT_FOUND));
    }
}
