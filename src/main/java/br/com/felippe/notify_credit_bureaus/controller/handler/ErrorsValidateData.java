package br.com.felippe.notify_credit_bureaus.controller.handler;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.FieldError;

@Schema(name = "ErrorsValidateData")
public record ErrorsValidateData(@Schema(example = "fieldName") String field,
		@Schema(example = "must not be blank") String message) {
	public ErrorsValidateData(FieldError error) {
		this(error.getField(), error.getDefaultMessage());
	}
}