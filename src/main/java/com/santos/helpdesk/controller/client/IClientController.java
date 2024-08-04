package com.santos.helpdesk.controller.client;

import com.santos.helpdesk.dto.ClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IClientController {
    @Operation(summary = "Busca de client por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<ClientDto> findById(@PathVariable long id);

    @Operation(summary = "Busca por todos os clientes na base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<List<ClientDto>> findAll();

    @Operation(summary = "Salvar um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<Void> save(@RequestBody @Valid ClientDto clientDto);

    @Operation(summary = "Atualizar dados de um cliente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto);

    @Operation(summary = "Deletar cliente por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<Void> delete(@PathVariable Long id);
}
