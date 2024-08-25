package com.santos.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santos.helpdesk.enums.Profile;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Technician {
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

    @OneToMany(mappedBy = "technician")
    @JsonIgnore
    private List<Called> called = new ArrayList<>();

    @PostConstruct
    public void initializeProfile() {
        this.profiles.add(Profile.TECHNIQUE);
    }
}
