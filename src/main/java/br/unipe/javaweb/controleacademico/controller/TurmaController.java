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

import br.unipe.javaweb.controleacademico.model.Turma;
import br.unipe.javaweb.controleacademico.service.DisciplinaService;
import br.unipe.javaweb.controleacademico.service.ProfessorService;
import br.unipe.javaweb.controleacademico.service.TurmaService;

@Controller
@RequestMapping(value="/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		map.addAttribute("turmas", turmaService.listar());
		return "turma/listar";
	}
	
	@RequestMapping(value="/incluir", method=RequestMethod.GET)
	public String incluir(ModelMap map){
		
		Turma turma = new Turma();
		
		map.addAttribute("turma", turma);
		map.addAttribute("disciplinas", disciplinaService.listar());
		map.addAttribute("professores", professorService.listar());
		
		return "turma/incluir";
	}

	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public String incluir(@ModelAttribute("turma") Turma turma, BindingResult result, ModelMap map, HttpSession session){
		turmaService.salvar(turma);
		return "redirect:listar";
	}	
	
	@RequestMapping(value="/editar/{id_turma}", method=RequestMethod.GET)
	public String editar(@PathVariable("id_turma") Long id_turma, ModelMap map, HttpSession session){

		Turma turma = turmaService.findById(id_turma);
		
		if (turma != null){
			map.addAttribute("turma", turma);
			map.addAttribute("disciplinas", disciplinaService.listar());
			map.addAttribute("professores", professorService.listar());			
		}
		
		return "turma/editar";
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
