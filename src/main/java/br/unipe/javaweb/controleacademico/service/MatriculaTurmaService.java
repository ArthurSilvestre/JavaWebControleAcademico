package br.unipe.javaweb.controleacademico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.unipe.javaweb.controleacademico.dao.MatriculaTurmaDAO;
import br.unipe.javaweb.controleacademico.model.Aluno;
import br.unipe.javaweb.controleacademico.model.MatriculaTurma;
import br.unipe.javaweb.controleacademico.model.Turma;

@Service
public class MatriculaTurmaService extends AbstractService<MatriculaTurmaDAO, MatriculaTurma> {

	public List<MatriculaTurma> obtemAlunos(Turma turma){
		return this.dao.obtemAlunos(turma);
	}
	
	public List<MatriculaTurma> obtemAlunos(String semestre, Aluno aluno){
		return this.dao.obtemNotasTurmas(semestre, aluno);
	}
	
	public List<MatriculaTurma> obtemHistorico(Aluno aluno){
		return this.dao.obtemHistorico(aluno);
	}		
}
