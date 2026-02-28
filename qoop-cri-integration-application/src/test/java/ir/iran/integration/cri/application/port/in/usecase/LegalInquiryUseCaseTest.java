package ir.iran.integration.cri.application.port.in.usecase;

import io.qoop.mapper.api.shift.Shift;
import io.qoop.utils.api.date.DateUtil;
import ir.iran.integration.cri.application.port.out.model.cmd.InquiryCmd;
import ir.iran.integration.cri.application.port.out.model.result.InquiryResult;
import ir.iran.integration.cri.application.port.out.port.InquiryPort;
import ir.iran.integration.cri.domain.model.view.CriProfileView;
import ir.iran.integration.cri.domain.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LegalInquiryUseCaseTest {

    @Mock
    private InquiryPort inquiryPort;

    @Mock
    private PersonService personService;

    @Mock
    private DateUtil dateUtil;

    @InjectMocks
    private LegalInquiryUseCase legalInquiryUseCase;

    @Test
    void processInquiry_ShouldReturnPortResult_WhenPortSucceeds() {
        // Arrange
        InquiryCmd cmd = mock(InquiryCmd.class);
        InquiryResult expectedPortResult = InquiryResult.builder().build();

        when(inquiryPort.sendInquiry(cmd)).thenReturn(expectedPortResult);

        // Act
        InquiryResult result = legalInquiryUseCase.processInquiry(cmd);

        // Assert
        assertNotNull(result);
        assertEquals(expectedPortResult, result);
        verify(inquiryPort, times(1)).sendInquiry(cmd);
        verify(personService, never()).findByIdentificationNoAndBirthDate(any(), any());
    }

    @Test
    void processInquiry_ShouldReturnDbResult_WhenPortFailsAndDbSucceeds() {
        // Arrange
        InquiryCmd cmd = mock(InquiryCmd.class);
        InquiryCmd.UserInputData userInputData = mock(InquiryCmd.UserInputData.class);
        InquiryCmd.RootData rootData = mock(InquiryCmd.RootData.class);

        when(cmd.getUserInputData()).thenReturn(userInputData);
        when(userInputData.getRoot()).thenReturn(rootData);
        when(rootData.getNationalNumberIn()).thenReturn("1234567890");
        when(rootData.getBirthDateIn()).thenReturn("1360/10/13");

        when(inquiryPort.sendInquiry(cmd)).thenThrow(new RuntimeException("Port Error"));

        LocalDate parsedDate = LocalDate.of(1982, 1, 3);
        when(dateUtil.parseFlexibleDate("1360/10/13")).thenReturn(parsedDate);

        CriProfileView profileView = mock(CriProfileView.class);
        when(personService.findByIdentificationNoAndBirthDate("1234567890", parsedDate)).thenReturn(profileView);

        InquiryResult.RowData mockRowData = InquiryResult.RowData.builder().fnameFa("علی").build();

        Shift shiftMock = mock(Shift.class);

        try (MockedStatic<Shift> shiftStaticMock = mockStatic(Shift.class)) {
            shiftStaticMock.when(() -> Shift.just(profileView)).thenReturn(shiftMock);
            when(shiftMock.toObject(InquiryResult.RowData.class)).thenReturn(mockRowData);

            // Act
            InquiryResult result = legalInquiryUseCase.processInquiry(cmd);

            // Assert
            assertNotNull(result);
            assertEquals("علی", result.getRoot().getRow().getFnameFa());
            verify(inquiryPort, times(1)).sendInquiry(cmd);
            verify(personService, times(1)).findByIdentificationNoAndBirthDate("1234567890", parsedDate);
        }
    }

    @Test
    void processInquiry_ShouldReturnMockData_WhenPortAndDbFail() {
        // Arrange
        InquiryCmd cmd = mock(InquiryCmd.class);
        InquiryCmd.UserInputData userInputData = mock(InquiryCmd.UserInputData.class);
        InquiryCmd.RootData rootData = mock(InquiryCmd.RootData.class);

        when(cmd.getUserInputData()).thenReturn(userInputData);
        when(userInputData.getRoot()).thenReturn(rootData);
        when(rootData.getNationalNumberIn()).thenReturn("1234567890");
        when(rootData.getBirthDateIn()).thenReturn("1360/10/13");

        when(inquiryPort.sendInquiry(cmd)).thenThrow(new RuntimeException("Port Error"));

        LocalDate parsedDate = LocalDate.of(1982, 1, 3);
        when(dateUtil.parseFlexibleDate("1360/10/13")).thenReturn(parsedDate);

        when(personService.findByIdentificationNoAndBirthDate("1234567890", parsedDate))
                .thenThrow(new RuntimeException("DB Error"));

        // Act
        InquiryResult result = legalInquiryUseCase.processInquiry(cmd);

        // Assert
        assertNotNull(result);
        assertNotNull(result.getRoot());
        assertNotNull(result.getRoot().getRow());
        assertEquals("بهروز", result.getRoot().getRow().getFnameFa()); // Check mock data value
        assertEquals("کاربر گرامي اطلاعات اين شخص به صورت ماک تولید و ارسال شده است.", result.getRoot().getRow().getInqDesc());

        verify(inquiryPort, times(1)).sendInquiry(cmd);
        verify(personService, times(1)).findByIdentificationNoAndBirthDate("1234567890", parsedDate);
    }
}