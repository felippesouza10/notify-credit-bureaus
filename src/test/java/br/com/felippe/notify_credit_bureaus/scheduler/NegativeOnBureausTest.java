package br.com.felippe.notify_credit_bureaus.scheduler;

import br.com.felippe.notify_credit_bureaus.model.DebtsToNegate;
import br.com.felippe.notify_credit_bureaus.producer.ProduceMessageToBureaus;
import br.com.felippe.notify_credit_bureaus.producer.dto.MessageDto;
import br.com.felippe.notify_credit_bureaus.repository.DebtsToNegateRepository;
import br.com.felippe.notify_credit_bureaus.enums.ProcessStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NegativeOnBureausTest {

    @Mock
    private DebtsToNegateRepository repository;

    @Mock
    private ProduceMessageToBureaus produceMessageToBureaus;

    @InjectMocks
    private NegativeOnBureaus negativeOnBureaus;

    private DebtsToNegate debt;

    @BeforeEach
    public void setUp() {
        debt = mock(DebtsToNegate.class);
        when(debt.getId()).thenReturn(UUID.randomUUID()); // Mockando o retorno do ID
    }

    @Test
    public void testNegative_whenDebtsFound() {
        List<DebtsToNegate> debts = Arrays.asList(debt);
        when(repository.findByStatus(ProcessStatus.PENDING)).thenReturn(debts);


        negativeOnBureaus.negative();


        verify(produceMessageToBureaus, times(1)).sendToBureau(any(MessageDto.class));
        verify(debt, times(1)).checkProcessed();
        verify(repository, times(1)).save(debt);
    }

    @Test
    public void testNegative_whenNoDebtsFound() {

        when(repository.findByStatus(ProcessStatus.PENDING)).thenReturn(Collections.emptyList());


        negativeOnBureaus.negative();


        verify(produceMessageToBureaus, never()).sendToBureau(any());
        verify(debt, never()).checkProcessed();
        verify(repository, never()).save(any());
    }


}
