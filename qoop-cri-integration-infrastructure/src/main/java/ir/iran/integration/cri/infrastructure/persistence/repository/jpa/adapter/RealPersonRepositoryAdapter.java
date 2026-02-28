package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.adapter;

import ir.iran.integration.cri.domain.model.domain.RealPerson;
import ir.iran.integration.cri.domain.repository.jpa.RealPersonRepository;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.entity.RealPersonEntity;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.mapper.RealPersonMapper;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.spring.RealPersonJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RealPersonRepositoryAdapter implements RealPersonRepository {

    private final RealPersonJpaRepository repository;
    private final RealPersonMapper mapper;


    @Override
    public RealPerson save(RealPerson domain) {
        RealPersonEntity entity = mapper.toTarget(domain);
        entity = repository.save(entity);
        return mapper.toSource(entity);
    }

    @Override
    public Optional<RealPerson> findById(Long id) {
        return mapper.toSource(repository.findById(id));
    }

    @Override
    public Boolean existById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void delete(RealPerson domain) {
        repository.delete(mapper.toTarget(domain));
    }
}
