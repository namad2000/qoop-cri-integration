package ir.iran.integration.cri.infrastructure.persistence.repository.jpa.mapper;

import io.qoop.mapper.core.CommonsMapperConfig;
import io.qoop.mapper.core.mapstruct.BasicMapper;
import ir.iran.integration.cri.domain.model.view.CriProfileView;
import ir.iran.integration.cri.infrastructure.persistence.repository.jpa.projection.CriProfileProjection;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface CriProfileMapper extends BasicMapper<CriProfileView, CriProfileProjection> {
}
