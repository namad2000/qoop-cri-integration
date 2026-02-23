package ir.iran.integration.cri.presentation.rest.resource;

import ir.iran.integration.cri.application.port.in.usecase.LegalInquiryUseCase;
import ir.iran.integration.cri.application.port.out.model.cmd.InquiryCmd;
import ir.iran.integration.cri.application.port.out.model.result.InquiryResult;
import ir.iran.integration.cri.presentation.rest.dto.request.InquiryRequest;
import ir.iran.integration.cri.presentation.rest.dto.response.InquiryResponse;
import ir.iran.integration.cri.presentation.rest.mapper.LegalInquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LegalInquiryResource {

    private final LegalInquiryUseCase legalInquiryUseCase;
    private final LegalInquiryMapper legalInquiryMapper;

    @PostMapping(value = "/customerinquiryV3")
    public InquiryResponse uploadImage(@RequestBody InquiryRequest inquiryRequest) {
        InquiryCmd inquiryCmd = legalInquiryMapper.toInquiryCmd(inquiryRequest);

        InquiryResult inquiryResult = legalInquiryUseCase.processInquiry(inquiryCmd);

        return legalInquiryMapper.toInquiryResponse(inquiryResult);
    }
}
