package com.ac2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ac2.dto.CursoDTO;
import com.ac2.entities.CursoEntity;
import com.ac2.entities.ProfessorEntity;
import com.ac2.repositories.CursoRepository;
import com.ac2.repositories.ProfessorRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<String> createCurso(CursoDTO curso) {
        CursoEntity entity = modelMapper.map(curso, CursoEntity.class);
        cursoRepository.save(entity);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity<List<CursoDTO>> getCursos() {
        List<CursoEntity> entities = this.cursoRepository.findAll();
        List<CursoDTO> results = new ArrayList<>();
        for (CursoEntity entity : entities) {
            results.add(this.modelMapper.map(entity, CursoDTO.class));
        }
        return ResponseEntity.ok().body(results);
    }

    public ResponseEntity<CursoDTO> editCurso(Long id, CursoEntity req) {
        CursoEntity curso = cursoRepository.findById(id).get();
        curso.setDesc(req.getDesc() != null ? req.getDesc() : curso.getDesc());
        curso.setEmenta(req.getEmenta() != null ? req.getEmenta() : curso.getEmenta());
        curso.setHours(req.getHours() != null ? req.getHours() : curso.getHours());
        curso.setObjectives(req.getObjectives() != null ? req.getObjectives() : curso.getObjectives());
        cursoRepository.save(curso);
        CursoDTO dto = modelMapper.map(curso, CursoDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    public ResponseEntity<String> deleteCurso(Long id) {
        cursoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Set<ProfessorEntity>> getProfessores(Long id) {
        CursoEntity curso = cursoRepository.findById(id).get();
        return ResponseEntity.ok().body(professorRepository.findByCursos(curso));
    }
}
