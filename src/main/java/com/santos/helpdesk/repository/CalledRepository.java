package com.santos.helpdesk.repository;

import com.santos.helpdesk.model.Called;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalledRepository extends JpaRepository<Called, Long> {
}
