package com.santos.helpdesk.mapper;

import com.santos.helpdesk.dto.CalledDto;
import com.santos.helpdesk.enums.Priority;
import com.santos.helpdesk.enums.Status;
import com.santos.helpdesk.model.Called;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CalledMapper {
    CalledMapper INSTANCE = Mappers.getMapper(CalledMapper.class);

    List<CalledDto> modelToDtoCalled(List<Called> called);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "openDate", target = "openDate"),
            @Mapping(source = "closingDate", target = "closingDate"),
            @Mapping(source = "priority", target = "priority"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "observation", target = "observation"),
            @Mapping(source = "technician.id", target = "technicianId"),
            @Mapping(source = "client.id", target = "clientId")
    })
    CalledDto modelToDtoCalled(Called called);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "openDate", target = "openDate"),
            @Mapping(source = "closingDate", target = "closingDate"),
            @Mapping(source = "priority", target = "priority"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "observation", target = "observation"),
            @Mapping(source = "technicianId", target = "technician.id"),
            @Mapping(source = "clientId", target = "client.id")
    })
    Called dtoToModel(CalledDto dto);

    default Long map(Priority priority) {
        return priority != null ? priority.getCode() : null;
    }

    default Priority map(Long priorityCode) {
        return Priority.toEnum(priorityCode);
    }

    default Long mapStatus(Status status) {
        return status != null ? status.getCode() : null;
    }

    default Status mapStatus(Long status) {
        return Status.toEnum(status);
    }
}
