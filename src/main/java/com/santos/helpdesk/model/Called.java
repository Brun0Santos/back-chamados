package com.santos.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santos.helpdesk.enums.Priority;
import com.santos.helpdesk.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Entity
public class Called {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openDate = LocalDate.now();

    @Builder.Default
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closingDate = LocalDate.now();

    private Priority priority;

    private Status status;

    private String title;

    private String observation;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
