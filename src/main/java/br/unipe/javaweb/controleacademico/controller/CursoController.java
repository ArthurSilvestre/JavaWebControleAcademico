package br.unipe.javaweb.controleacademico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/curso")
public class CursoController {

	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		return "curso/listar";
	}

	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editar(ModelMap map){
		return "curso/editar";
	}

	@RequestMapping(value="/incluir", method=RequestMethod.GET)
	public String incluir(ModelMap map){
		return "curso/incluir";
	}
}
