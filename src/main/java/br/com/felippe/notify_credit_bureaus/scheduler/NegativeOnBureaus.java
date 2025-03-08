package br.com.felippe.notify_credit_bureaus.scheduler;

import br.com.felippe.notify_credit_bureaus.enums.ProcessStatus;
import br.com.felippe.notify_credit_bureaus.model.DebtsToNegate;
import br.com.felippe.notify_credit_bureaus.producer.ProduceMessageToBureaus;
import br.com.felippe.notify_credit_bureaus.producer.dto.MessageDto;
import br.com.felippe.notify_credit_bureaus.repository.DebtsToNegateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NegativeOnBureaus {

    private static final Logger logger = LoggerFactory.getLogger(NegativeOnBureaus.class);

    @Value("${app.scheduled.negative.cron}")
    private String cronExpression;

    private final DebtsToNegateRepository repository;
    private final ProduceMessageToBureaus produceMessageToBureaus;

    public NegativeOnBureaus(DebtsToNegateRepository repository, ProduceMessageToBureaus produceMessageToBureaus) {
        this.repository = repository;
        this.produceMessageToBureaus = produceMessageToBureaus;
    }

    @Scheduled(cron = "${app.scheduled.negative.cron}")
    public void negative(){
        List<DebtsToNegate> debtsToNegates = repository.findByStatus(ProcessStatus.PENDING);

        debtsToNegates.forEach( debt -> {
            produceMessageToBureaus.sendToBureau(new MessageDto(debt));
            debt.checkProcessed();
            repository.save(debt);
            logger.info("{} was processed", debt.getId());
        });

        if(debtsToNegates.isEmpty()){
            logger.info("There are no debts to process");
        }
    }
}
