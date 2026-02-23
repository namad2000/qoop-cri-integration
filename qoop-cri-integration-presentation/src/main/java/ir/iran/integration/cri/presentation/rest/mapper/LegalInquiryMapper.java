package ir.iran.integration.cri.presentation.rest.mapper;

import io.qoop.mapper.core.CommonsMapperConfig;
import ir.iran.integration.cri.application.port.out.model.cmd.InquiryCmd;
import ir.iran.integration.cri.application.port.out.model.result.InquiryResult;
import ir.iran.integration.cri.presentation.rest.dto.request.InquiryRequest;
import ir.iran.integration.cri.presentation.rest.dto.response.InquiryResponse;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface LegalInquiryMapper {
    InquiryCmd toInquiryCmd(InquiryRequest inquiryRequest);

    InquiryResponse toInquiryResponse(InquiryResult inquiryResult);
}