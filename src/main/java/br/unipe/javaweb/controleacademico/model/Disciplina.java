package br.unipe.javaweb.controleacademico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Disciplina;
	
	private String nome;
	
	private String area;
	
	@ManyToOne
	private Curso curso;
	
	public Disciplina(){
		
	}

	public Long getId_Disciplina() {
		return id_Disciplina;
	}

	public void setId_Disciplina(Long id_Disciplina) {
		this.id_Disciplina = id_Disciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
