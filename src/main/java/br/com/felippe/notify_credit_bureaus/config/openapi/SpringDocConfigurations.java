package br.com.felippe.notify_credit_bureaus.config.openapi;

import br.com.felippe.notify_credit_bureaus.controller.dto.DebtResponseDto;
import br.com.felippe.notify_credit_bureaus.controller.handler.ProblemDTO;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SpringDocConfigurations {


	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Notify Credit Bureaus API")
						.version("v1")
						.description("")
						.contact(new Contact().name("Felippe Souza")
								.email("felipao@gmail.com")))
			.components(new Components().schemas(this.generateSchemas()));
	}

	@SuppressWarnings("rawtypes")
	private Map<String, Schema> generateSchemas() {
		final Map<String, Schema> schemaMap = new HashMap<>();

		Map<String, Schema> problemSchema = ModelConverters.getInstance().read(ProblemDTO.class);
		Map<String, Schema> debtResponseDto = ModelConverters.getInstance().read(DebtResponseDto.class);


		Schema errorsValidateDataArraySchema = new ArraySchema()
			.items(new Schema<>().$ref("#/components/schemas/ErrorsValidateData"));

		schemaMap.putAll(problemSchema);
		schemaMap.putAll(debtResponseDto);
		schemaMap.put("ErrorsValidateDataList", errorsValidateDataArraySchema);

		return schemaMap;
	}

}