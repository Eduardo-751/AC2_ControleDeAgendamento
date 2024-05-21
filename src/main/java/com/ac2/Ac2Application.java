package com.ac2;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ac2.entities.AgendaEntity;
import com.ac2.entities.CursoEntity;
import com.ac2.entities.ProfessorEntity;
import com.ac2.repositories.AgendaRepository;
import com.ac2.repositories.CursoRepository;
import com.ac2.repositories.ProfessorRepository;

@SpringBootApplication
public class Ac2Application {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public CommandLineRunner init(@Autowired CursoRepository cursoRepository,
			@Autowired ProfessorRepository professorRepository, @Autowired AgendaRepository agendaRepository) {
		return args -> {
			// Create Curso
			CursoEntity curso1 = new CursoEntity();
			curso1.setDesc("Fisioterapia");
			curso1.setHours("20");
			curso1.setObjectives(
					"Formar profissionais capacitados e éticos, com sólidos conhecimentos teóricos e práticos na área da fisioterapia");
			curso1.setEmenta(
					"Introdução à Anatomia e Fisiologia, Bases da Biomecânica, Introdução à Prática Fisioterapêutica, Avaliação Clínica Básica");
			cursoRepository.save(curso1); // Salvar o Curso1

			// Create Professor
			ProfessorEntity professor1 = new ProfessorEntity();
			professor1.setName("Arnaldo César");
			professor1.setCpf("12345678901");
			professor1.setRg("1234567");
			professor1.setAddress("Some Address");
			professor1.setPhone("123456789");
			Set<CursoEntity> cursosForProfessor1 = new HashSet<>();
			cursosForProfessor1.add(curso1);
			professor1.setCursos(cursosForProfessor1);
			professorRepository.save(professor1); // Salvar o Professor1

			ProfessorEntity professor2 = new ProfessorEntity();
			professor2.setName("Marcelo Alberto");
			professor2.setCpf("12131415161");
			professor2.setRg("7654321");
			professor2.setAddress("Another Address");
			professor2.setPhone("987654321");
			Set<CursoEntity> cursosForProfessor2 = new HashSet<>();
			cursosForProfessor2.add(curso1);
			professor2.setCursos(cursosForProfessor2);
			professorRepository.save(professor2); // Salvar o Professor2

			// Create Agenda
			AgendaEntity agenda1 = new AgendaEntity();
			agenda1.setStart_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2024-03-17 8:00:00"));
			agenda1.setEnd_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2024-03-20 17:00:00"));
			agenda1.setCity("Marília");
			agenda1.setState("SP");
			agenda1.setCep("123321");
			agenda1.setCursos(curso1);
			agenda1.setProfessores(professor1);
			agendaRepository.save(agenda1);

			AgendaEntity agenda2 = new AgendaEntity();
			agenda2.setStart_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2024-03-17 08:00:00"));
			agenda2.setEnd_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2024-03-19 17:00:00"));
			agenda2.setCity("Sorocaba");
			agenda2.setState("SP");
			agenda2.setCep("18050000");
			agenda2.setCursos(curso1);
			agenda2.setProfessores(professor2);
			agendaRepository.save(agenda2);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac2Application.class, args);
	}

}
