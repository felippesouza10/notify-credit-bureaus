package br.com.felippe.notify_credit_bureaus.service.impl;

import br.com.felippe.notify_credit_bureaus.controller.dto.DebtRequestDto;
import br.com.felippe.notify_credit_bureaus.model.DebtsToNegate;
import br.com.felippe.notify_credit_bureaus.repository.DebtsToNegateRepository;
import br.com.felippe.notify_credit_bureaus.service.DebtService;
import org.springframework.stereotype.Service;

@Service
public class DebtServiceImpl implements DebtService {

    private final DebtsToNegateRepository repository;

    public DebtServiceImpl(DebtsToNegateRepository repository) {
        this.repository = repository;
    }

    public DebtsToNegate create(DebtRequestDto dto) {
        return repository.save(new DebtsToNegate(dto));
    }
}
