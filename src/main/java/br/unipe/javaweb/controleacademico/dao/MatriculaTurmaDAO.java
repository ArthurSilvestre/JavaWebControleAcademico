package br.unipe.javaweb.controleacademico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unipe.javaweb.controleacademico.model.MatriculaTurma;

public interface MatriculaTurmaDAO extends JpaRepository<MatriculaTurma, Long> {

}
