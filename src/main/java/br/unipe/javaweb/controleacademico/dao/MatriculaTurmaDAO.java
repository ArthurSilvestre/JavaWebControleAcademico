package br.unipe.javaweb.controleacademico.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unipe.javaweb.controleacademico.model.Aluno;
import br.unipe.javaweb.controleacademico.model.MatriculaTurma;
import br.unipe.javaweb.controleacademico.model.Turma;

public interface MatriculaTurmaDAO extends JpaRepository<MatriculaTurma, Long> {

	@Query("select mt from MatriculaTurma mt where mt.turma = ?1")
	public List<MatriculaTurma> obtemAlunos(Turma turma);
	
	@Query("select mt from MatriculaTurma mt where mt.turma.semestre = ?1 and mt.aluno = ?2")
	public List<MatriculaTurma> obtemNotasTurmas(String semestre, Aluno aluno);
	
	@Query("select mt from MatriculaTurma mt where mt.aluno = ?1")
	public List<MatriculaTurma> obtemHistorico(Aluno aluno);		
	
}
