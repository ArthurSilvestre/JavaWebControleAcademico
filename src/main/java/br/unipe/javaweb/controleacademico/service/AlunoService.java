package br.unipe.javaweb.controleacademico.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import br.unipe.javaweb.controleacademico.dao.AlunoDAO;
import br.unipe.javaweb.controleacademico.model.Aluno;

@Service
public class AlunoService extends AbstractService<AlunoDAO, Aluno> {

	public String generateRandomPassword() {
		Random random = new Random();
		return ""+random.nextInt(999999);
	}
	
}
