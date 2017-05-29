package br.unipe.javaweb.controleacademico.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaFisica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_PessoaFisica;
	
	private String cpf;
	
	private String nome;
	
	private Date dataNascimento;
	
	private String email;
	
	private String senha;

	@ManyToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;

	public Long getId_PessoaFisica() {
		return id_PessoaFisica;
	}

	public void setId_PessoaFisica(Long id_PessoaFisica) {
		this.id_PessoaFisica = id_PessoaFisica;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
