package br.com.felippe.notify_credit_bureaus.exceptions;

public class ErrorToSentSQSException extends RuntimeException {

	public ErrorToSentSQSException(String message) {
		super(message);
	}

}
