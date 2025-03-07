package com.ac2.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac2.dto.AgendaDTO;
import com.ac2.dto.ProfessorAgendaDTO;
import com.ac2.services.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    public ResponseEntity<String> createAgenda(@RequestBody AgendaDTO agenda, @RequestParam Long curso,
            @RequestParam Long professor) throws ParseException {
        return agendaService.createAgenda(agenda, curso, professor);
    }

    @GetMapping
    public ResponseEntity<List<AgendaDTO>> getAgendas() {
        return agendaService.getAgendas();
    }

    @GetMapping("/professor")
    public ResponseEntity<List<ProfessorAgendaDTO>> getAgendaByProfessor(@RequestParam Long id) {
        return this.agendaService.getAgendasByProfessor(id);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAgenda(@RequestBody Long id) {
        return agendaService.deleteAgenda(id);
    }

}
