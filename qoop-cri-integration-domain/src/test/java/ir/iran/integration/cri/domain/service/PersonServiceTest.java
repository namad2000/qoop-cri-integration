package ir.iran.integration.cri.domain.service;

import io.qoop.fault.handler.api.exception.DomainBusinessException;
import ir.iran.integration.cri.domain.model.view.CriProfileView;
import ir.iran.integration.cri.domain.repository.jpa.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void findByIdentificationNoAndBirthDate_ShouldReturnView_WhenPersonExists() {
        // 1. Arrange (Given)
        String nationalCode = "0123456789";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);

        // ساخت آبجکت CriProfileView با استفاده از Constructor (چون Record است)
        CriProfileView mockView = new CriProfileView(
                1L, 2L, "CODE", "Display Name", nationalCode,
                "123", 1370, "INIT", "ACC", "Display En",
                "SUB", "FOR", "TOK2",
                100L, 1, LocalDate.now(), null, LocalDate.now(),
                "Ali", "Alavi", "Mohammad", birthDate, "Ali", "Alavi", "123", "P123",
                "021-8888", "09121111", "12345", "021-9999", "a@b.com", "Tehran", "JobTeh", "021-7777", "111"
        );

        when(personRepository.findByIdentificationNoAndBirthDate(eq(nationalCode), eq(birthDate)))
                .thenReturn(Optional.of(mockView));

        // 2. Act (When)
        CriProfileView result = personService.findByIdentificationNoAndBirthDate(nationalCode, birthDate);

        // 3. Assert (Then)
        assertNotNull(result);
        assertEquals("Ali", result.firstName());
        assertEquals(nationalCode, result.identificationNo());

        verify(personRepository, times(1)).findByIdentificationNoAndBirthDate(eq(nationalCode), eq(birthDate));
    }

    @Test
    void findByIdentificationNoAndBirthDate_ShouldThrowException_WhenPersonNotFound() {
        // 1. Arrange (Given)
        String nationalCode = "0000000000";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);

        when(personRepository.findByIdentificationNoAndBirthDate(eq(nationalCode), eq(birthDate)))
                .thenReturn(Optional.empty());

        // 2. Act & Assert (When & Then)
        assertThrows(DomainBusinessException.class, () -> {
            personService.findByIdentificationNoAndBirthDate(nationalCode, birthDate);
        });

        verify(personRepository, times(1)).findByIdentificationNoAndBirthDate(eq(nationalCode), eq(birthDate));
    }
}