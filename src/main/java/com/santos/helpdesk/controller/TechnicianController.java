package com.santos.helpdesk.controller;

import com.santos.helpdesk.model.Technician;
import com.santos.helpdesk.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/technician")
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;

    @GetMapping("/id")
    public ResponseEntity<Technician> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(technicianService.findById(id));
    }
}
