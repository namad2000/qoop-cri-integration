package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.mapper;

import io.qoop.mapper.core.CommonsMapperConfig;
import io.qoop.mapper.core.mapstruct.BasicMapper;
import ir.iran.integration.cri.domain.model.domain.RealPerson;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.entity.RealPersonEntity;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface RealPersonMapper extends BasicMapper<RealPerson, RealPersonEntity> {
}
