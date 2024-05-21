package com.ac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ac2.entities.AgendaEntity;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {

    List<AgendaEntity> findByProfessoresId(Long professorId);

}
