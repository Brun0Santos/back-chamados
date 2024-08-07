package com.santos.helpdesk.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santos.helpdesk.enums.Profile;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Data
public class TechnicianDto {
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "O cpf é obrigatório")
    private String cpf;

    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "A senha é obrigatório")
    private String password;

    private Set<Profile> profiles = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate = LocalDate.now();
}
