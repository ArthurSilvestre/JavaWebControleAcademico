package br.unipe.javaweb.controleacademico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unipe.javaweb.controleacademico.model.Curso;

public interface CursoDAO extends JpaRepository<Curso, Long> {

}
