package br.com.felippe.notify_credit_bureaus.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.util.UUID;

public record DebtRequestDto(@CPF String cpf,
                             @NotNull UUID debtId,
                             @NotNull @Positive BigDecimal debtValue) {
}
