package com.santos.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santos.helpdesk.enums.Profile;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Client {
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

    @OneToMany(mappedBy = "client")
    private List<Called> called = new ArrayList<>();

    @PostConstruct
    public void initializeProfile() {
        this.profiles.add(Profile.CLIENT);
    }
}
