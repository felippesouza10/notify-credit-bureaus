package br.com.felippe.notify_credit_bureaus.producer;

import br.com.felippe.notify_credit_bureaus.producer.dto.MessageDto;

public interface ProduceMessageToBureaus {

   void sendToBureau(MessageDto dto);
}
