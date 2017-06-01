package br.unipe.javaweb.controleacademico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/aluno")
public class AlunoController {
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		return "aluno/listar";
	}
	
	@RequestMapping(value="/incluir", method=RequestMethod.GET)
	public String incluir(ModelMap map){
		return "aluno/incluir";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editar(ModelMap map){
		return "aluno/editar";
	}
	
	@RequestMapping(value="/notas", method=RequestMethod.GET)
	public String notas(ModelMap map){
		return "aluno/notas";
	}
	
	@RequestMapping(value="/historico", method=RequestMethod.GET)
	public String historico(ModelMap map){
		return "aluno/historico";
	}
	
}
