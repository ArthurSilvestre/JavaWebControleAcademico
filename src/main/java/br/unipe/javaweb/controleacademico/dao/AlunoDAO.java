package br.unipe.javaweb.controleacademico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unipe.javaweb.controleacademico.model.Aluno;;

public interface AlunoDAO extends JpaRepository<Aluno, Long> {

}
