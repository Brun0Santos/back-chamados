package com.santos.helpdesk.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalledDto {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closingDate = LocalDate.now();

    @NotBlank(message = "O campo Prioridade é obrigatório")
    private Long priority;

    @NotBlank(message = "O campo Status é obrigatório")
    private Long status;

    @NotBlank(message = "O campo Título é obrigatório")
    private String title;

    @NotBlank(message = "O campo Observação é obrigatório")
    private String observation;

    @NotBlank(message = "O campo Técnico é obrigatório")
    private Long technicianId;

    @NotBlank(message = "O campo Cliente é obrigatório")
    private Long clientId;
}
