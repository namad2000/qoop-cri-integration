package ir.iran.integration.cri.infrastructure.port.out.mapper;

import io.qoop.mapper.core.CommonsMapperConfig;
import ir.iran.integration.cri.application.port.out.model.cmd.InquiryCmd;
import ir.iran.integration.cri.application.port.out.model.result.InquiryResult;
import ir.iran.integration.cri.infrastructure.port.out.client.dto.request.InquiryRequest;
import ir.iran.integration.cri.infrastructure.port.out.client.dto.response.InquiryResponse;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface ClientInquiryMapper {
    InquiryRequest toInquiryRequest(InquiryCmd inquiryCmd);

    InquiryResult toInquiryResult(InquiryResponse inquiryResponse);
}