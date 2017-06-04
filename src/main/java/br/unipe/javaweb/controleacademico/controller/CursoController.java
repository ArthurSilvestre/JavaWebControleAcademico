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

import br.unipe.javaweb.controleacademico.model.Curso;
import br.unipe.javaweb.controleacademico.service.CursoService;

@Controller
@RequestMapping(value="/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;	

	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		map.addAttribute("cursos", cursoService.listar());
		return "curso/listar";
	}

	@RequestMapping(value="/incluir", method=RequestMethod.GET)
	public String incluir(ModelMap map){
		
		Curso curso = new Curso(); 
		
		map.addAttribute("curso", curso);
		
		return "curso/incluir";
	}

	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public String incluir(@ModelAttribute("curso") Curso curso, BindingResult result, ModelMap map, HttpSession session){
		cursoService.salvar(curso);
		return "redirect:listar";
	}

	@RequestMapping(value="/editar/{id_curso}", method=RequestMethod.GET)
	public String editar(@PathVariable("id_curso") Long id_curso, ModelMap map, HttpSession session){
		Curso curso = cursoService.findById(id_curso);
		
		if (curso != null){
			map.addAttribute("curso", curso);
		}
		
		return "curso/editar";
	}	

	@RequestMapping(value="/deletar/{id_curso}", method=RequestMethod.GET)
	public String deletar(@PathVariable("id_curso") Long id_curso, ModelMap map){
		Curso curso = cursoService.findById(id_curso);
		
		if (curso != null){
			cursoService.deletar(curso);
		}
		
		return "redirect:../listar";
	}	
	
}
