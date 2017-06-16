package br.unipe.javaweb.controleacademico.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import br.unipe.javaweb.controleacademico.dao.ProfessorDAO;
import br.unipe.javaweb.controleacademico.model.Professor;

@Service
public class ProfessorService extends AbstractService<ProfessorDAO, Professor> {

	public String generateRandomPassword() {
		Random random = new Random();
		return ""+random.nextInt(999999);
	}
	
}
