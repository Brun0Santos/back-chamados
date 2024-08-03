package com.santos.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santos.helpdesk.enums.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String password;

    private Set<Long> profiles = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datCreate = LocalDate.now();

    public Person(Long id, String name, String cpf, String email, String password) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;;
    }

    public Person() {
        addProfile(Profile.CLIENT);
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(Profile::toEnum).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getCode());
    }
}
