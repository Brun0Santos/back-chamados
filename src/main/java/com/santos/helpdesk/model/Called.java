package com.santos.helpdesk.model;

import com.santos.helpdesk.enums.Priority;
import com.santos.helpdesk.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Called {
    private Long id;
    @Builder.Default
    private LocalDate openDate = LocalDate.now();
    @Builder.Default
    private LocalDate closingDate = LocalDate.now();
    private Priority priority;
    private Status status;
    private String title;
    private String observation;
    private Technician technician;
    private Client client;
}
