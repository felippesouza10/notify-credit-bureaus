package br.com.felippe.notify_credit_bureaus.service;

import br.com.felippe.notify_credit_bureaus.controller.dto.DebtRequestDto;
import br.com.felippe.notify_credit_bureaus.model.DebtsToNegate;

public interface DebtService {
    DebtsToNegate create(DebtRequestDto dto);

}
