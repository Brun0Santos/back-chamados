package com.santos.helpdesk.service.client.impl;

import com.santos.helpdesk.dto.ClientDto;
import com.santos.helpdesk.exceptions.ExistingDataException;
import com.santos.helpdesk.exceptions.NotFoundException;
import com.santos.helpdesk.mapper.ClientMapper;
import com.santos.helpdesk.model.Client;
import com.santos.helpdesk.model.Technician;
import com.santos.helpdesk.repository.ClientRepository;
import com.santos.helpdesk.service.client.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Override
    public ClientDto findById(long id) {
        Client client = clientRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Client not found"));
        return clientMapper.modelToDtoClient(client);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientMapper.modelToDtoClient(clientRepository.findAll());
    }

    @Transactional
    @Override
    public void save(ClientDto clientDto) {
        checkTechnicianExists(clientDto.getCpf(), clientDto.getEmail());
        clientRepository.save(clientMapper.dtoToModel(clientDto));
    }

    @Transactional
    @Override
    public ClientDto update(Long id, ClientDto dto) {
        checkTechnicianExistsById(id);
        checkTechnicianExists(dto.getCpf(), dto.getEmail());
        Client client = clientMapper.dtoToModel(dto);
        clientRepository.save(client);
        return dto;
    }

    @Override
    public void delete(Long id) {
        Client client = checkTechnicianExistsById(id);
        if (!client.getCalled().isEmpty()) throw new DataIntegrityViolationException("Linked service order");
        clientRepository.deleteById(id);
    }

    private Client checkTechnicianExistsById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Technician Not Found"));

    }

    public void checkTechnicianExists(String cpf, String email) {
        checkIfTechnicianExists(clientRepository.findByCpf(cpf), "Existing CPF");
        checkIfTechnicianExists(clientRepository.findByEmail(email), "Existing EMAIL");
    }

    private void checkIfTechnicianExists(Optional<Technician> technician, String errorMessage) {
        if (technician.isPresent()) {
            throw new ExistingDataException(errorMessage);
        }
    }
}