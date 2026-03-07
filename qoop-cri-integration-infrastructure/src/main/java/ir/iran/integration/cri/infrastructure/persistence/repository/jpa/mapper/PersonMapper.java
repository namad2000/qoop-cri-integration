package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.mapper;

import io.qoop.mapper.api.mapper.BasicMapper;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.iran.integration.cri.domain.model.domain.Person;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface PersonMapper extends BasicMapper<Person, PersonEntity> {
}
