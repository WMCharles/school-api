package com.example.schoolapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schoolapi.entity.Darasa;
import com.example.schoolapi.repository.DarasaRepository;
import com.example.schoolapi.service.DarasaService;

@Service
public class DarasaServiceImpl implements DarasaService {

    @Autowired
    private DarasaRepository darasaRepository;

    @Override
    public List<Darasa> getAllClassRooms() {
        return darasaRepository.findAll();
    }

    @Override
    public Darasa getDarasaById(Long id) {
        return darasaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class room not found with id: " + id));
    }

    @Override
    public Darasa saveDarasa(Darasa student) {
        return darasaRepository.save(student);
    }

    @Override
    public void deleteDarasa(Long id) {
        darasaRepository.deleteById(id);
    }

    @Override
    public Darasa updateDarasa(Long id, Darasa darasaDetails) {
        Darasa darasa = getDarasaById(id);
        darasa.setName(darasaDetails.getName());
        darasa.setCode(darasaDetails.getCode());
        return darasaRepository.save(darasa);
    }
}
