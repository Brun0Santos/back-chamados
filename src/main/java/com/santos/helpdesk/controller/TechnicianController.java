package com.santos.helpdesk.controller;

import com.santos.helpdesk.dto.TechnicianDto;
import com.santos.helpdesk.service.TechnicianService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/technician")
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianDto> findById(@PathVariable long id) {
        System.out.println(id);
        return ResponseEntity.ok().body(technicianService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TechnicianDto>> findAll() {
        return ResponseEntity.ok().body(technicianService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid TechnicianDto technicianDto) {
        technicianService.save(technicianDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnicianDto> update(@PathVariable Long id, @RequestBody TechnicianDto request) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(technicianService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        technicianService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
