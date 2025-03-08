package br.com.felippe.notify_credit_bureaus.repository;

import br.com.felippe.notify_credit_bureaus.enums.ProcessStatus;
import br.com.felippe.notify_credit_bureaus.model.DebtsToNegate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DebtsToNegateRepository extends JpaRepository<DebtsToNegate, UUID> {

    List<DebtsToNegate> findByStatus(ProcessStatus status);
}