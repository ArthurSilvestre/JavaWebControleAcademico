package br.unipe.javaweb.controleacademico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unipe.javaweb.controleacademico.model.Administrador;

public interface AdministradorDAO extends JpaRepository<Administrador, Long>{

}
