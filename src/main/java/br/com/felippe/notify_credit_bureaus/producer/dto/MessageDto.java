package br.com.felippe.notify_credit_bureaus.producer.dto;

import br.com.felippe.notify_credit_bureaus.model.DebtsToNegate;

import java.math.BigDecimal;
import java.util.UUID;

public record MessageDto(String cpf, UUID debtId, BigDecimal debtValue, String createdAt) {
    public MessageDto(DebtsToNegate debt) {
        this(debt.getCpf(), debt.getDebtId(), debt.getDebtValue(), debt.getCreatedAt().toString());
    }
}
