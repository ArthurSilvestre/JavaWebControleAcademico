package br.unipe.javaweb.controleacademico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.unipe.javaweb.controleacademico.dao.TurmaDAO;
import br.unipe.javaweb.controleacademico.model.Professor;
import br.unipe.javaweb.controleacademico.model.Turma;

@Service
public class TurmaService extends AbstractService<TurmaDAO, Turma>  {

	public List<Turma> obtemTurmasPorProfessorESemestre(String semestre, Professor professor){
		return this.dao.obtemTurmasPorProfessorESemestre(semestre, professor);
	}
		
}
