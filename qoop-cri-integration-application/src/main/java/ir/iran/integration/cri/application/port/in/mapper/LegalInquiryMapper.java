package ir.iran.integration.cri.application.port.in.mapper;


import io.qoop.filter.bean.api.DomainMapper;
import io.qoop.mapper.api.mapper.TargetMapper;
import io.qoop.mapper.api.shift.Shift;
import ir.iran.integration.cri.application.port.out.model.result.InquiryResult;
import ir.iran.integration.cri.domain.model.view.CriProfileView;

import java.time.format.DateTimeFormatter;

@DomainMapper
public class LegalInquiryMapper implements TargetMapper<CriProfileView, InquiryResult> {
    @Override
    public InquiryResult toTarget(CriProfileView criProfileView) {
        InquiryResult.RowData rowData = Shift.just(criProfileView)
                .toShift(InquiryResult.RowData.class)
                .map(rowDataTrans -> {
                    if (criProfileView == null) {
                        return null;
                    }

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                    rowDataTrans.setFnameFa(criProfileView.firstName());
                    rowDataTrans.setFnameEn(criProfileView.firstNameEn());
                    rowDataTrans.setLnameFa(criProfileView.lastName());
                    rowDataTrans.setLnameEn(criProfileView.lastNameEn());
                    rowDataTrans.setFatherNameFa(criProfileView.fatherName());
                    rowDataTrans.setFatherNameEn(null);

                    rowDataTrans.setIdNumber(criProfileView.id() != null ? criProfileView.id().intValue() : null);
                    rowDataTrans.setIdSeri(criProfileView.code());
                    rowDataTrans.setIdSerial(criProfileView.lastId() != null ? criProfileView.lastId().intValue() : null);

                    try {
                        rowDataTrans.setNationalNumber(criProfileView.identificationNo() != null ? Long.parseLong(criProfileView.identificationNo()) : null);
                    } catch (NumberFormatException e) {
                        rowDataTrans.setNationalNumber(null);
                    }

                    rowDataTrans.setGender(null);
                    rowDataTrans.setIsDead(criProfileView.deathDate() != null ? "Y" : "N");
                    rowDataTrans.setDeathDate(criProfileView.deathDate() != null ? criProfileView.deathDate().format(formatter) : null);
                    rowDataTrans.setVerificationDatetime(criProfileView.verificationDate() != null ? criProfileView.verificationDate().format(formatter) : null);

                    try {
                        rowDataTrans.setZipCode(criProfileView.postCode() != null ? Long.parseLong(criProfileView.postCode()) : null);
                    } catch (NumberFormatException e) {
                        rowDataTrans.setZipCode(null);
                    }
                    rowDataTrans.setShabaCode(null);
                    rowDataTrans.setPdmId(criProfileView.pdmid() != null ? criProfileView.pdmid().intValue() : null);

                    rowDataTrans.setInqStatus(null);
                    rowDataTrans.setInqDesc(null);
                    rowDataTrans.setSystemError(null);
                    rowDataTrans.setSystemPersianError(null);
                    rowDataTrans.setSabtError(null);
                    rowDataTrans.setSabtPersianError(null);
                    rowDataTrans.setSabtException(null);
                    rowDataTrans.setSabtPersianException(null);
                    rowDataTrans.setInqDesc("کاربر گرامي اطلاعات اين شخص از دیتابیس واکشی و ارسال شده است.");

                    return rowDataTrans;
                })
                .toObject();

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
