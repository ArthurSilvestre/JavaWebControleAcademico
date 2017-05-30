package br.unipe.javaweb.controleacademico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unipe.javaweb.controleacademico.model.Disciplina;;

public interface DisciplinaDAO extends JpaRepository<Disciplina, Long> {
 
}
