package com.santos.helpdesk.model;

import com.santos.helpdesk.enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class Person {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private Set<Long> profiles = new HashSet<>();
    private LocalDate datCreate = LocalDate.now();

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
