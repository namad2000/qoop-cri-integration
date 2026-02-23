package ir.iran.integration.cri.application.port.out.port;

import ir.iran.integration.cri.application.port.out.model.cmd.InquiryCmd;
import ir.iran.integration.cri.application.port.out.model.result.InquiryResult;

public interface InquiryPort {
    InquiryResult sendInquiry(InquiryCmd inquiryCmd);
}