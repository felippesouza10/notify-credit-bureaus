package br.com.felippe.notify_credit_bureaus.controller.dto;

import br.com.felippe.notify_credit_bureaus.enums.ProcessStatus;
import br.com.felippe.notify_credit_bureaus.model.DebtsToNegate;

import java.math.BigDecimal;
import java.util.UUID;

public record DebtResponseDto(UUID id,
                              String cpf,
                              UUID debtId,
                              BigDecimal debtValue,
                              ProcessStatus status,
                              String createdAt) {

    public DebtResponseDto(DebtsToNegate debt) {
        this(debt.getId(), debt.getCpf(), debt.getDebtId(), debt.getDebtValue(), debt.getStatus(), debt.getCreatedAt().toString());
    }
}
