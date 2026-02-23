package ir.iran.integration.cri.infrastructure.port.out.client.feign;

import ir.iran.integration.cri.infrastructure.port.out.client.dto.request.InquiryRequest;
import ir.iran.integration.cri.infrastructure.port.out.client.dto.response.InquiryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inquiryClient", url = "${leqal.inquiry.url}")
public interface LegalInquiryClient {

    @PostMapping(value = "/inquiry", consumes = "application/json", produces = "application/json")
    InquiryResponse sendInquiry(@RequestBody InquiryRequest request);
}