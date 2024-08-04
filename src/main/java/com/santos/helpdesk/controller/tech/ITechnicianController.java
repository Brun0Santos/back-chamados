package com.santos.helpdesk.controller.tech;

import com.santos.helpdesk.dto.TechnicianDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITechnicianController {
    @Operation(summary = "Busca de técnico por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<TechnicianDto> findById(@PathVariable long id);

    @Operation(summary = "Busca por todos os técnico na base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<List<TechnicianDto>> findAll();

    @Operation(summary = "Salvar um técnico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<Void> save(@RequestBody @Valid TechnicianDto technicianDto);

    @Operation(summary = "Atualizar dados de um técnico por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<TechnicianDto> update(@PathVariable Long id, @RequestBody TechnicianDto request);

    @Operation(summary = "Deletar técnico por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<Void> delete(@PathVariable Long id);
}
