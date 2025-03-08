package br.com.felippe.notify_credit_bureaus.producer.impl;

import br.com.felippe.notify_credit_bureaus.exceptions.ErrorToSentSQSException;
import br.com.felippe.notify_credit_bureaus.producer.ProduceMessageToBureaus;
import br.com.felippe.notify_credit_bureaus.producer.dto.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProduceMessageToBureausImpl implements ProduceMessageToBureaus {


    @Value("${sqs.queue.bureau.debt.producer}")
    private String produceBureauQueue;

    private final SqsTemplate sqsTemplate;
    private final ObjectMapper objectMapper;

    public ProduceMessageToBureausImpl(SqsTemplate sqsTemplate, ObjectMapper objectMapper) {
        this.sqsTemplate = sqsTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendToBureau(MessageDto dto) {
        try {
            sqsTemplate.send(produceBureauQueue, objectMapper.writeValueAsString(dto));
        } catch (JsonProcessingException e) {
            throw new ErrorToSentSQSException("It was not possible to send the message in SQS queue");
        }
    }
}
