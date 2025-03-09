package br.com.felippe.notify_credit_bureaus.scheduler;

import br.com.felippe.notify_credit_bureaus.model.DebtsToNegate;
import br.com.felippe.notify_credit_bureaus.producer.ProduceMessageToBureaus;
import br.com.felippe.notify_credit_bureaus.producer.dto.MessageDto;
import br.com.felippe.notify_credit_bureaus.repository.DebtsToNegateRepository;
import br.com.felippe.notify_credit_bureaus.scheduler.NegativeOnBureaus;
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
        // Inicializando o objeto de dívida para o teste
        debt = mock(DebtsToNegate.class);
        when(debt.getId()).thenReturn(UUID.randomUUID()); // Mockando o retorno do ID
    }

    @Test
    public void testNegative_whenDebtsFound() {
        // Dado que temos uma lista de dívidas
        List<DebtsToNegate> debts = Arrays.asList(debt);
        when(repository.findByStatus(ProcessStatus.PENDING)).thenReturn(debts);

        // Chama o método negativo
        negativeOnBureaus.negative();

        // Verificando se o método foi chamado
        verify(produceMessageToBureaus, times(1)).sendToBureau(any(MessageDto.class));
        verify(debt, times(1)).checkProcessed();
        verify(repository, times(1)).save(debt);
    }

    @Test
    public void testNegative_whenNoDebtsFound() {
        // Dado que não existem dívidas para processar
        when(repository.findByStatus(ProcessStatus.PENDING)).thenReturn(Collections.emptyList());

        // Chama o método negativo
        negativeOnBureaus.negative();

        // Verifica que nenhum método foi chamado
        verify(produceMessageToBureaus, never()).sendToBureau(any());
        verify(debt, never()).checkProcessed();
        verify(repository, never()).save(any());
    }
}
