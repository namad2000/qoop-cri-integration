package ir.iran.integration.cri.application.port.in.usecase;

import io.qoop.utils.api.date.DateUtil;
import ir.iran.integration.cri.application.port.in.mapper.LegalInquiryMapper;
import ir.iran.integration.cri.application.port.out.model.cmd.InquiryCmd;
import ir.iran.integration.cri.application.port.out.model.result.InquiryResult;
import ir.iran.integration.cri.application.port.out.port.InquiryPort;
import ir.iran.integration.cri.domain.model.view.CriProfileView;
import ir.iran.integration.cri.domain.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Enable Spring extension to load context and Mockito extension for mocking
@ExtendWith({SpringExtension.class, MockitoExtension.class})
// Load both Mapper and UseCase. Spring will create the UseCase and inject the mocks/spy defined below.
@ContextConfiguration(classes = {LegalInquiryMapper.class, LegalInquiryUseCase.class})
class LegalInquiryUseCaseTest {

    // Use MockitoBean for dependencies that need to be pure mocks
    @MockitoBean
    private InquiryPort inquiryPort;

    @MockitoBean
    private PersonService personService;

    @MockitoBean
    private DateUtil dateUtil;

    // Use SpyBean to inject the real Spring bean of LegalInquiryMapper
    @MockitoSpyBean
    private LegalInquiryMapper legalInquiryMapper;

    // Inject the actual UseCase instance created by Spring context
    @Autowired
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
        String nationalNumber = "1234567890";
        String birthDateStr = "1360/10/13";
        LocalDate parsedDate = LocalDate.of(1982, 1, 3);

        setupCommonMocks(cmd, nationalNumber, birthDateStr, parsedDate);

        when(inquiryPort.sendInquiry(cmd)).thenThrow(new RuntimeException("Port Error"));

        CriProfileView profileView = mock(CriProfileView.class);
        when(personService.findByIdentificationNoAndBirthDate(nationalNumber, parsedDate)).thenReturn(profileView);

        // Fix: Mock the result object instead of using builder()
        InquiryResult expectedDbResult = mock(InquiryResult.class);

        // Create the nested mock structure for the result
        InquiryResult.RootData mockRoot = mock(InquiryResult.RootData.class);
        InquiryResult.RowData mockRow = InquiryResult.RowData.builder().fnameFa("علی").build();

        // Now we can stub the methods because expectedDbResult is a mock
        when(expectedDbResult.getRoot()).thenReturn(mockRoot);
        when(mockRoot.getRow()).thenReturn(mockRow);

        // Use doReturn instead of when(...).thenReturn(...)
        doReturn(expectedDbResult).when(legalInquiryMapper).toTarget(profileView);

        // Act
        InquiryResult result = legalInquiryUseCase.processInquiry(cmd);

        // Assert
        assertNotNull(result);
        assertEquals("علی", result.getRoot().getRow().getFnameFa());
        verify(inquiryPort, times(1)).sendInquiry(cmd);
        verify(personService, times(1)).findByIdentificationNoAndBirthDate(nationalNumber, parsedDate);
        verify(legalInquiryMapper, times(1)).toTarget(profileView);
    }

    @Test
    void processInquiry_ShouldReturnMockData_WhenPortAndDbFail() {
        // Arrange
        InquiryCmd cmd = mock(InquiryCmd.class);
        String nationalNumber = "1234567890";
        String birthDateStr = "1360/10/13";
        LocalDate parsedDate = LocalDate.of(1982, 1, 3);

        setupCommonMocks(cmd, nationalNumber, birthDateStr, parsedDate);

        when(inquiryPort.sendInquiry(cmd)).thenThrow(new RuntimeException("Port Error"));
        when(personService.findByIdentificationNoAndBirthDate(nationalNumber, parsedDate))
                .thenThrow(new RuntimeException("DB Error"));

        // Act
        // Calls the real 'getMockData' method in LegalInquiryMapper via SpyBean
        InquiryResult result = legalInquiryUseCase.processInquiry(cmd);

        // Assert
        assertNotNull(result);
        assertNotNull(result.getRoot());
        assertNotNull(result.getRoot().getRow());
        assertEquals("بهروز", result.getRoot().getRow().getFnameFa());
        assertEquals("کاربر گرامي اطلاعات اين شخص به صورت ماک تولید و ارسال شده است.", result.getRoot().getRow().getInqDesc());

        verify(inquiryPort, times(1)).sendInquiry(cmd);
        verify(personService, times(1)).findByIdentificationNoAndBirthDate(nationalNumber, parsedDate);
    }

    // Helper method to setup common command mocks and reduce code duplication
    private void setupCommonMocks(InquiryCmd cmd, String nationalNumber, String birthDateStr, LocalDate parsedDate) {
        InquiryCmd.UserInputData userInputData = mock(InquiryCmd.UserInputData.class);
        InquiryCmd.RootData rootData = mock(InquiryCmd.RootData.class);

        when(cmd.getUserInputData()).thenReturn(userInputData);
        when(userInputData.getRoot()).thenReturn(rootData);
        when(rootData.getNationalNumberIn()).thenReturn(nationalNumber);
        when(rootData.getBirthDateIn()).thenReturn(birthDateStr);
        when(dateUtil.parseFlexibleDate(birthDateStr)).thenReturn(parsedDate);
    }
}