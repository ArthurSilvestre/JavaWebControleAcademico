package br.unipe.javaweb.controleacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.javaweb.controleacademico.service.DisciplinaService;

@Controller
@RequestMapping(value="/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;	
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		return "disciplina/listar";
	}
	
	@RequestMapping(value="/incluir", method=RequestMethod.GET)
	public String incluir(ModelMap map){
		return "disciplina/incluir";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editar(ModelMap map){
		return "disciplina/editar";
	}	
	
}
