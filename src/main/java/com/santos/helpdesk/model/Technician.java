package com.santos.helpdesk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technician extends Person {
    @OneToMany(mappedBy = "technician")
    private List<Called> called = new ArrayList<>();
}
