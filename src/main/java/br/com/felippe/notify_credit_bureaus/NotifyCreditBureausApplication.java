package br.com.felippe.notify_credit_bureaus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NotifyCreditBureausApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotifyCreditBureausApplication.class, args);
	}

}
