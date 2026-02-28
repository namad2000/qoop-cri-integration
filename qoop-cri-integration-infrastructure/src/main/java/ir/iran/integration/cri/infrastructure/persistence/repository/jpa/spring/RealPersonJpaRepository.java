package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.spring;


import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.entity.RealPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealPersonJpaRepository extends JpaRepository<RealPersonEntity, Long> {
}