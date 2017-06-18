package br.unipe.javaweb.controleacademico.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unipe.javaweb.controleacademico.model.Professor;
import br.unipe.javaweb.controleacademico.model.Turma;

public interface TurmaDAO extends JpaRepository<Turma, Long> {

	@Query("select t from Turma t where t.semestre = ?1 and t.professor = ?2")
	public List<Turma> obtemTurmasPorProfessorESemestre(String semestre, Professor professor);
	
}
