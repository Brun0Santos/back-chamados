package com.santos.helpdesk.repository;

import com.santos.helpdesk.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
