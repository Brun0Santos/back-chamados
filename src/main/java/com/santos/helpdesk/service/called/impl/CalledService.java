package com.santos.helpdesk.service.called.impl;

import com.santos.helpdesk.dto.CalledDto;
import com.santos.helpdesk.exceptions.NotFoundException;
import com.santos.helpdesk.mapper.CalledMapper;
import com.santos.helpdesk.model.Called;
import com.santos.helpdesk.repository.CalledRepository;
import com.santos.helpdesk.service.called.ICalledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalledService implements ICalledService {

    @Autowired
    private CalledRepository calledRepository;

    private final CalledMapper calledMapper = CalledMapper.INSTANCE;

    @Override
    public CalledDto findById(long id) {
        Called called = calledRepository.findById(id).orElseThrow(() -> new NotFoundException("Called not found"));
        return calledMapper.modelToDtoClient(called);
    }

    @Override
    public List<CalledDto> findAll() {
        return calledMapper.modelToDtoClient(calledRepository.findAll());
    }

    @Override
    public void save(CalledDto dto) {
        calledRepository.save(calledMapper.dtoToModel(dto));
    }

    @Override
    public CalledDto update(Long id, CalledDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
