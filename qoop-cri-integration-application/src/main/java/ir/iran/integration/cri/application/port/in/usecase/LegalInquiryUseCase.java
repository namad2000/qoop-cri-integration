package ir.iran.integration.cri.application.port.in.usecase;


import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.mapper.api.shift.Shift;
import io.qoop.utils.api.date.DateUtil;
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
    private final DateUtil dateUtil;

    public InquiryResult processInquiry(InquiryCmd inquiryCmd) {
        try {
            return inquiryPort.sendInquiry(inquiryCmd);
        } catch (Exception portException) {
            try {
                return getFromPerson(inquiryCmd);
            } catch (Exception dbException) {
                return getMockData();
            }
        }
    }

    private InquiryResult getFromPerson(InquiryCmd inquiryCmd) {
        String identificationNo = inquiryCmd.getUserInputData().getRoot().getNationalNumberIn();
        String strBirthDate = inquiryCmd.getUserInputData().getRoot().getBirthDateIn();
        LocalDate birthDate = dateUtil.parseFlexibleDate(strBirthDate);

        CriProfileView criProfileView = personService.findByIdentificationNoAndBirthDate(identificationNo, birthDate);

        return toInquiryResult(criProfileView);
    }

    private InquiryResult toInquiryResult(CriProfileView criProfileView) {
        InquiryResult.RowData rowData = Shift.just(criProfileView).toObject(InquiryResult.RowData.class);

        return InquiryResult.builder()
                .root(
                        InquiryResult.RootData.builder()
                                .row(rowData)
                                .build()
                )
                .build();
    }


    // --- Mock Data Usage Example ---
    public InquiryResult getMockData() {
        return InquiryResult.builder()
                .root(InquiryResult.RootData.builder()
                        .row(InquiryResult.RowData.builder()
                                .fnameFa("بهروز")
                                .fnameEn("Behrooz")
                                .lnameFa("کهریزی")
                                .lnameEn("Kahrizi")
                                .fatherNameFa("فیض اله")
                                .fatherNameEn("Feizollah")
                                .idNumber(3202)
                                .idSeri("ا18")
                                .idSerial(582122)
                                .birthDate("1360/10/13")
                                .nationalNumber(3255380294L)
                                .gender("male")
                                .isDead("FALSE")
                                .deathDate("")
                                .isVerified("TRUE")
                                .verificationDatetime("1403/07/18  12:28:27")
                                .inqStatus("PDM")
                                .inqDesc("کاربر گرامي اطلاعات اين شخص به صورت ماک تولید و ارسال شده است.")
                                .shabaCode("IR000000000000000000000000")
                                .pdmId(36517248)
                                .zipCode(1781743656L)
                                .systemError("")
                                .systemPersianError("")
                                .sabtError("err.record.not.found")
                                .sabtPersianError("هیچ رکوردی یافت نشد")
                                .sabtException("")
                                .sabtPersianException("")
                                .build())
                        .build())
                .build();
    }
}