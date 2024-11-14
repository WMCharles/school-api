package com.example.schoolapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schoolapi.entity.Darasa;
import com.example.schoolapi.service.DarasaService;

@RestController
@RequestMapping("/api/darasa")
public class DarasaController {

    @Autowired
    private DarasaService darasaService;

    @GetMapping
    public List<Darasa> getAllClassRooms() {
        return darasaService.getAllClassRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Darasa> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(darasaService.getDarasaById(id));
    }

    @PostMapping
    public ResponseEntity<Darasa> createStudent(@RequestBody Darasa darasa) {
        System.out.println("Received Payload: " + darasa);
        return ResponseEntity.ok(darasaService.saveDarasa(darasa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Darasa> updateDarasa(@PathVariable Long id, @RequestBody Darasa student) {
        return ResponseEntity.ok(darasaService.updateDarasa(id, student));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Darasa> pathcStudent(@PathVariable Long id, @RequestBody Darasa student) {
        return ResponseEntity.ok(darasaService.updateDarasa(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDarasa(@PathVariable Long id) {
        darasaService.deleteDarasa(id);
        return ResponseEntity.noContent().build();
    }
}
