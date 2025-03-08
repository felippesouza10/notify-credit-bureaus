package br.com.felippe.notify_credit_bureaus.controller;

import br.com.felippe.notify_credit_bureaus.controller.dto.DebtRequestDto;
import br.com.felippe.notify_credit_bureaus.controller.dto.DebtResponseDto;
import br.com.felippe.notify_credit_bureaus.controller.openapi.DebtsControllerOpenApi;
import br.com.felippe.notify_credit_bureaus.service.DebtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/debts")
public class DebtsController implements DebtsControllerOpenApi {

    private final DebtService debtService;

    public DebtsController(DebtService debtService) {
        this.debtService = debtService;
    }

    @PostMapping
    public ResponseEntity<DebtResponseDto> createDebt(@RequestBody DebtRequestDto dto){
        var debtCreated = debtService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DebtResponseDto(debtCreated));
    }
}
