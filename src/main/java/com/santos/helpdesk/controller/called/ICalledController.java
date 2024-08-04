package com.santos.helpdesk.controller.called;

import com.santos.helpdesk.dto.CalledDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICalledController {
    @Operation(summary = "Busca de chamado por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<CalledDto> findById(long id);

    @Operation(summary = "Busca por todos os chamados na base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<List<CalledDto>> findAll();

    @Operation(summary = "Salvar um chamado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<Void> save(@RequestBody @Valid CalledDto calledDto);

    @Operation(summary = "Atualizar dados de um chamado por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<CalledDto> update(@PathVariable Long id, @RequestBody CalledDto calledDto);

    @Operation(summary = "Deletar chamado por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content)
    })
    ResponseEntity<Void> delete(@PathVariable Long id);
}
