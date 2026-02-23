package ir.iran.integration.cri.infrastructure.port.out.adapter;

import ir.iran.integration.cri.application.port.out.model.cmd.InquiryCmd;
import ir.iran.integration.cri.application.port.out.model.result.InquiryResult;
import ir.iran.integration.cri.application.port.out.port.InquiryPort;
import ir.iran.integration.cri.infrastructure.port.out.client.dto.request.InquiryRequest;
import ir.iran.integration.cri.infrastructure.port.out.client.dto.response.InquiryResponse;
import ir.iran.integration.cri.infrastructure.port.out.client.feign.LegalInquiryClient;
import ir.iran.integration.cri.infrastructure.port.out.mapper.ClientInquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InquiryFeignAdapter implements InquiryPort {

    private final LegalInquiryClient feignClient;
    private final ClientInquiryMapper clientInquiryMapper;

    @Override
    public InquiryResult sendInquiry(InquiryCmd request) {
        InquiryRequest inquiryRequest = clientInquiryMapper.toInquiryRequest(request);
        InquiryResponse inquiryResponse = feignClient.sendInquiry(inquiryRequest);
        return clientInquiryMapper.toInquiryResult(inquiryResponse);
    }
}