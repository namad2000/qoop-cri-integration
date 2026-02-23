package ir.iran.integration.cri.application.port.in.usecase;


import io.qoop.filter.bean.api.UseCaseService;
import ir.iran.integration.cri.application.port.out.model.cmd.InquiryCmd;
import ir.iran.integration.cri.application.port.out.model.result.InquiryResult;
import ir.iran.integration.cri.application.port.out.port.InquiryPort;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class LegalInquiryUseCase {

    private final InquiryPort inquiryPort;

    public InquiryResult processInquiry(InquiryCmd inquiryCmd) {

        return inquiryPort.sendInquiry(inquiryCmd);
    }
}