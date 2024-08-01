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
public class Client extends Person {
    @OneToMany(mappedBy = "client")
    private List<Called> called = new ArrayList<>();
}
