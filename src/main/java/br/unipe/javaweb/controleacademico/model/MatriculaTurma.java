package br.unipe.javaweb.controleacademico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MatriculaTurma extends Observable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_MatriculaTurma;
	
	@OneToOne
	private Turma turma;
	
	@OneToOne
	private Aluno aluno;
	
	private float notaPrimeiroEstagio;
	
	private float notaSegundoEstagio;
	
	private float notaTerceiroEstagio;
	
	private float notaFinal;
	
	public MatriculaTurma(){
		super();
	}
	
	public float getMedia(){
		return (getNotaPrimeiroEstagio() + getNotaSegundoEstagio() + getNotaTerceiroEstagio())/3;
	}

	public Long getId_MatriculaTurma() {
		return id_MatriculaTurma;
	}

	public void setId_MatriculaTurma(Long id_MatriculaTurma) {
		this.id_MatriculaTurma = id_MatriculaTurma;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public float getNotaPrimeiroEstagio() {
		return notaPrimeiroEstagio;
	}

	public void setNotaPrimeiroEstagio(float notaPrimeiroEstagio) {
		if (this.notaPrimeiroEstagio != notaPrimeiroEstagio){
			if (this.getListeners().isEmpty()) this.addListener(this.aluno);
			this.notifyListeners("Primerio Estágio");
		}
		
		this.notaPrimeiroEstagio = notaPrimeiroEstagio;
	}

	public float getNotaSegundoEstagio() {
		return notaSegundoEstagio;
	}

	public void setNotaSegundoEstagio(float notaSegundoEstagio) {
		if (this.notaSegundoEstagio != notaSegundoEstagio){
			if (this.getListeners().isEmpty()) this.addListener(this.aluno);
			this.notifyListeners("Segundo Estágio");
		}

		this.notaSegundoEstagio = notaSegundoEstagio;
	}

	public float getNotaTerceiroEstagio() {
		return notaTerceiroEstagio;
	}

	public void setNotaTerceiroEstagio(float notaTerceiroEstagio) {
		if (this.notaTerceiroEstagio != notaTerceiroEstagio){
			if (this.getListeners().isEmpty()) this.addListener(this.aluno);
			this.notifyListeners("Terceiro Estágio");
		}

		this.notaTerceiroEstagio = notaTerceiroEstagio;
	}

	public float getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(float notaFinal) {
		if (this.notaFinal != notaFinal){
			if (this.getListeners().isEmpty()) this.addListener(this.aluno);
			this.notifyListeners("Final");
		}

		this.notaFinal = notaFinal;
	}
	
}
