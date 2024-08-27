package com.santos.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santos.helpdesk.enums.Profile;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String password;

    private Set<Profile> profiles = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate = LocalDate.now();

    public Set<Profile> getProfiles() {
        return profiles.stream().map(x -> Profile.toEnum(x.getCode())).collect(Collectors.toSet());
    }

    @PostConstruct
    public void initializeProfile() {
        this.profiles.add(Profile.TECHNIQUE);
    }
}
