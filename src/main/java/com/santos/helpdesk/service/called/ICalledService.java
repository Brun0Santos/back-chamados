package com.santos.helpdesk.service.called;

import com.santos.helpdesk.dto.CalledDto;

import java.util.List;

public interface ICalledService {
    CalledDto findById(long id);

    List<CalledDto> findAll();

    void save(CalledDto dto);

    CalledDto update(Long id, CalledDto dto);

    void delete(Long id);
}
