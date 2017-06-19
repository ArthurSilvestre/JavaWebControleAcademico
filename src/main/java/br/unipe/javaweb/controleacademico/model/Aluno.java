package br.unipe.javaweb.controleacademico.model;

import java.util.Date;

import javax.mail.MessagingException;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import br.unipe.javaweb.controleacademico.utils.EmailManager;

@Entity
@PrimaryKeyJoinColumn(name="id_PessoaFisica")
public class Aluno extends PessoaFisica implements IListener{

	private Date dataVinculo;
	
	public Aluno(){}
	
	public Date getDataVinculo() {
		return dataVinculo;
	}

	public void setDataVinculo(Date dataVinculo) {
		this.dataVinculo = dataVinculo;
	}

	@Override
	public void sendNotification(String estagio) {
		try {
			EmailManager emailManager = new EmailManager();
			emailManager.sendMail();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
