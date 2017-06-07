package br.unipe.javaweb.controleacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.javaweb.controleacademico.model.Turma;
import br.unipe.javaweb.controleacademico.service.TurmaService;

@Controller
@RequestMapping(value="/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;		
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		map.addAttribute("turmas", turmaService.listar());
		return "turma/listar";
	}
	
	@RequestMapping(value="/incluir", method=RequestMethod.GET)
	public String incluir(ModelMap map){
		return "turma/incluir";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editar(ModelMap map){
		return "turma/editar";
	}

	@RequestMapping(value="/matricular", method=RequestMethod.GET)
	public String matricular(ModelMap map){
		return "turma/matricular";
	}
	
	@RequestMapping(value="/deletar/{id_turma}", method=RequestMethod.GET)
	public String deletar(@PathVariable("id_turma") Long id_turma, ModelMap map){
		Turma turma = turmaService.findById(id_turma);
		
		if (turma != null){
			turmaService.deletar(turma);
		}
		
		return "redirect:../listar";
	}		
	
}
