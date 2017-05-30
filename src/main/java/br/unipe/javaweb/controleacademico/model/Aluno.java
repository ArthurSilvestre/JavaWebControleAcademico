package br.unipe.javaweb.controleacademico.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id_PessoaFisica")
public class Aluno extends PessoaFisica {

	private Date dataVinculo;
	
	public Aluno(){}
	
	public Date getDataVinculo() {
		return dataVinculo;
	}

	public void setDataVinculo(Date dataVinculo) {
		this.dataVinculo = dataVinculo;
	}
	
}
