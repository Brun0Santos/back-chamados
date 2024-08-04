package com.santos.helpdesk.controller.client.impl;

import com.santos.helpdesk.controller.client.IClientController;
import com.santos.helpdesk.dto.ClientDto;
import com.santos.helpdesk.service.client.impl.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/client")
public class ClientController implements IClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ClientDto> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(clientService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid ClientDto technicianDto) {
        clientService.save(technicianDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto request) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clientService.update(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
