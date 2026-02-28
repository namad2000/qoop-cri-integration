package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.adapter;

import ir.iran.integration.cri.domain.model.domain.RealPerson;
import ir.iran.integration.cri.domain.repository.jpa.RealPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RealPersonRepositoryAdapter implements RealPersonRepository {
    @Override
    public RealPerson save(RealPerson domain) {
        return null;
    }

    @Override
    public Optional<RealPerson> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Boolean existById(Long aLong) {
        return null;
    }

    @Override
    public void delete(RealPerson domain) {

    }
}
