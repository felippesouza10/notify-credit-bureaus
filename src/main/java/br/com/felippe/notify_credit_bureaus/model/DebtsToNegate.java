package br.com.felippe.notify_credit_bureaus.model;

import br.com.felippe.notify_credit_bureaus.controller.dto.DebtRequestDto;
import br.com.felippe.notify_credit_bureaus.enums.ProcessStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "debts_to_negate")
public class DebtsToNegate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String cpf;

    private UUID debtId;

    private BigDecimal debtValue;

    @Enumerated(EnumType.STRING)
    private ProcessStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public DebtsToNegate(DebtRequestDto dto) {
        this.cpf = dto.cpf();
        this.debtId = dto.debtId();
        this.debtValue = dto.debtValue();
        this.status = ProcessStatus.PENDING;
    }

    public DebtsToNegate(){

    }

    public UUID getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public UUID getDebtId() {
        return debtId;
    }

    public BigDecimal getDebtValue() {
        return debtValue;
    }

    public ProcessStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void checkProcessed() {
        status = ProcessStatus.PROCESSED;
    }
}
