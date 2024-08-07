package com.santos.helpdesk.controller.called.impl;

import com.santos.helpdesk.controller.called.ICalledController;
import com.santos.helpdesk.dto.CalledDto;
import com.santos.helpdesk.service.called.impl.CalledService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/called")
public class CalledControllerImpl implements ICalledController {

    @Autowired
    private CalledService calledService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CalledDto> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(calledService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CalledDto>> findAll() {
        return ResponseEntity.ok().body(calledService.findAll());
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid CalledDto calledDto) {
        calledService.save(calledDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @PutMapping
    public ResponseEntity<CalledDto> update(@PathVariable @Valid Long id, CalledDto calledDto) {
        return null;
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> delete(Long id) {
        return null;
    }
}
