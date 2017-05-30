package br.unipe.javaweb.controleacademico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unipe.javaweb.controleacademico.model.Endereco;

public interface EnderecoDAO extends JpaRepository<Endereco, Long> {

}
