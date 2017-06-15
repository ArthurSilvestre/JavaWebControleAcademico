package br.unipe.javaweb.controleacademico.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.javaweb.controleacademico.model.Disciplina;
import br.unipe.javaweb.controleacademico.service.CursoService;
import br.unipe.javaweb.controleacademico.service.DisciplinaService;

@Controller
@RequestMapping(value="/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private CursoService cursoService;	
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		map.addAttribute("disciplinas", disciplinaService.listar());
		return "disciplina/listar";
	}
	
	@RequestMapping(value="/incluir", method=RequestMethod.GET)
	public String incluir(ModelMap map){
		
		Disciplina disciplina = new Disciplina();
		
		map.addAttribute("disciplina", disciplina);
		map.addAttribute("cursos", cursoService.listar());
		
		return "disciplina/incluir";
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public String incluir(@ModelAttribute("disciplina") Disciplina disciplina, BindingResult result, ModelMap map, HttpSession session){
		disciplinaService.salvar(disciplina);
		return "redirect:listar";
	}	
	
	@RequestMapping(value="/editar/{id_disciplina}", method=RequestMethod.GET)
	public String editar(@PathVariable("id_disciplina") Long id_disciplina, ModelMap map, HttpSession session){
		Disciplina disciplina = disciplinaService.findById(id_disciplina);
		
		if (disciplina != null){
			map.addAttribute("disciplina", disciplina);
			map.addAttribute("cursos", cursoService.listar());
		}
		
		return "disciplina/editar";
	}	
	
	@RequestMapping(value="/deletar/{id_disciplina}", method=RequestMethod.GET)
	public String deletar(@PathVariable("id_disciplina") Long id_disciplina, ModelMap map){
		Disciplina disciplina = disciplinaService.findById(id_disciplina);
		
		if (disciplina != null){
			disciplinaService.deletar(disciplina);
		}
		
		return "redirect:../listar";
	}	
	
}
