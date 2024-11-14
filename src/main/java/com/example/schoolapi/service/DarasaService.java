package com.example.schoolapi.service;

import java.util.List;

import com.example.schoolapi.entity.Darasa;

public interface DarasaService {

    List<Darasa> getAllClassRooms();

    Darasa getDarasaById(Long id);

    Darasa saveDarasa(Darasa darasa);

    void deleteDarasa(Long id);

    Darasa updateDarasa(Long id, Darasa darasa);
}
