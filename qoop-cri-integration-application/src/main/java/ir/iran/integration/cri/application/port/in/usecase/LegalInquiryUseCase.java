package ir.iran.integration.cri.application.port.in.usecase;


import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.utils.api.date.DateUtil;
import ir.iran.integration.cri.application.port.in.mapper.LegalInquiryMapper;
import ir.iran.integration.cri.application.port.out.model.cmd.InquiryCmd;
import ir.iran.integration.cri.application.port.out.model.result.InquiryResult;
import ir.iran.integration.cri.application.port.out.port.InquiryPort;
import ir.iran.integration.cri.domain.model.view.CriProfileView;
import ir.iran.integration.cri.domain.service.PersonService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@UseCaseService
@RequiredArgsConstructor
public class LegalInquiryUseCase {

    private final InquiryPort inquiryPort;
    private final PersonService personService;
    private final LegalInquiryMapper legalInquiryMapper;
    private final DateUtil dateUtil;

    public InquiryResult processInquiry(InquiryCmd inquiryCmd) {
        try {
            return inquiryPort.sendInquiry(inquiryCmd);
        } catch (Exception portException) {
            try {
                return getFromPerson(inquiryCmd);
            } catch (Exception dbException) {
                return legalInquiryMapper.getMockData();
            }
        }
    }

    private InquiryResult getFromPerson(InquiryCmd inquiryCmd) {
        String identificationNo = inquiryCmd.getUserInputData().getRoot().getNationalNumberIn();
        String strBirthDate = inquiryCmd.getUserInputData().getRoot().getBirthDateIn();
        LocalDate birthDate = dateUtil.parseFlexibleDate(strBirthDate);

        CriProfileView criProfileView = personService.findByIdentificationNoAndBirthDate(identificationNo, birthDate);

        return legalInquiryMapper.toTarget(criProfileView);
    }
}