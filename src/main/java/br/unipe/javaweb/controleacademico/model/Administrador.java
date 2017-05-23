package br.unipe.javaweb.controleacademico.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id_PessoaFisica")
public class Administrador extends PessoaFisica {

}
