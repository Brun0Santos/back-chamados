package com.santos.helpdesk.service.client;

import com.santos.helpdesk.dto.ClientDto;
import com.santos.helpdesk.dto.TechnicianDto;

import java.util.List;

public interface IClientService {
    ClientDto findById(long id);

    List<ClientDto> findAll();

    void save(ClientDto technicianDto);

    ClientDto update(Long id, ClientDto dto);

    void delete(Long id);
}
