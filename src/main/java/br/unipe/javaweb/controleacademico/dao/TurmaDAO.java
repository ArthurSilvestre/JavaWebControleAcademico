package br.unipe.javaweb.controleacademico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unipe.javaweb.controleacademico.model.Turma;

public interface TurmaDAO extends JpaRepository<Turma, Long> {

}
