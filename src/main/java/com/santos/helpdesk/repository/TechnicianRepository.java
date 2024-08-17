package com.santos.helpdesk.repository;

import com.santos.helpdesk.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    Optional<Technician> findByCpf(String email);

    Optional<Technician> findByEmail(String email);
}
