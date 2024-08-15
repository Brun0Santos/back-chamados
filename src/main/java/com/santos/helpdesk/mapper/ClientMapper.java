package com.santos.helpdesk.mapper;

import com.santos.helpdesk.dto.ClientDto;
import com.santos.helpdesk.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    List<ClientDto> modelToDtoClient(List<Client> clients);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "cpf", target = "cpf"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password")
    })
    ClientDto modelToDtoClient(Client client);

    Client dtoToModel(ClientDto dto);
}
