package com.santos.helpdesk.mapper;

import com.santos.helpdesk.dto.TechnicianDto;
import com.santos.helpdesk.model.Technician;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TechnicianMapper {
    TechnicianMapper INSTANCE = Mappers.getMapper(TechnicianMapper.class);

    List<TechnicianDto> dtoToModelTechnician(List<Technician> technicians);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "cpf", target = "cpf"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password")
    })
    TechnicianDto dtoToModelTechnician(Technician technician);

    Technician dtoToModel(TechnicianDto dto);
}
