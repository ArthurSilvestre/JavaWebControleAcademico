package br.unipe.javaweb.controleacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.javaweb.controleacademico.model.Professor;
import br.unipe.javaweb.controleacademico.service.ProfessorService;

@Controller
@RequestMapping(value="/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;		
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		map.addAttribute("professores", professorService.listar());
		return "professor/listar";
	}
	
	@RequestMapping(value="/incluir", method=RequestMethod.GET)
	public String incluir(ModelMap map){
		return "professor/incluir";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editar(ModelMap map){
		return "professor/editar";
	}	

	@RequestMapping(value="/disciplinas", method=RequestMethod.GET)
	public String disciplinas(ModelMap map){
		return "professor/disciplinas";
	}
	
	@RequestMapping(value="/lancarnotas", method=RequestMethod.GET)
	public String lancarnotas(ModelMap map){
		return "professor/lancarnotas";
	}
	
	@RequestMapping(value="/deletar/{id_pessoafisica}", method=RequestMethod.GET)
	public String deletar(@PathVariable("id_pessoafisica") Long id_pessoafisica, ModelMap map){
		Professor professor = professorService.findById(id_pessoafisica);
		
		if (professor != null){
			professorService.deletar(professor);
		}
		
		return "redirect:../listar";
	}		
}
