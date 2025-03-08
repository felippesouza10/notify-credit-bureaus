package br.com.felippe.notify_credit_bureaus.controller.openapi;

import br.com.felippe.notify_credit_bureaus.controller.dto.DebtRequestDto;
import br.com.felippe.notify_credit_bureaus.controller.dto.DebtResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Debts")
public interface DebtsControllerOpenApi {

    @Operation(summary = "Create Debt To Sent To Bureau")
    @ApiResponse(responseCode = "201", description = "Created Response",
            content = @Content(mediaType = "application/json", schema = @Schema(ref = "DebtRequestDto")))
    @ApiResponse(responseCode = "500", description = "Internal Server Error Response",
            content = @Content(mediaType = "application/json", schema = @Schema(ref = "ProblemDto")))
    ResponseEntity<DebtResponseDto> createDebt(DebtRequestDto dto);
}
