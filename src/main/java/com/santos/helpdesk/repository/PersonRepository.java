package com.santos.helpdesk.repository;

import com.santos.helpdesk.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
