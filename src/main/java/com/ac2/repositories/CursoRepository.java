package com.ac2.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ac2.entities.CursoEntity;
import com.ac2.entities.ProfessorEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
    Set<CursoEntity> findByProfessores(ProfessorEntity professor);
}
