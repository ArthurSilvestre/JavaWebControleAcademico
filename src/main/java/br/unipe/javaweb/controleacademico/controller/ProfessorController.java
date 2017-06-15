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
		
		Professor professor = new Professor();
		
		map.addAttribute("professor", professor);
		
		return "professor/incluir";
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public String incluir(@ModelAttribute("professor") Professor professor, BindingResult result, ModelMap map, HttpSession session){
		professorService.salvar(professor);
		return "redirect:listar";
	}	
	
	@RequestMapping(value="/editar/{id_PessoaFisica}", method=RequestMethod.GET)
	public String editar(@PathVariable("id_PessoaFisica") Long id_PessoaFisica, ModelMap map, HttpSession session){
		Professor professor = professorService.findById(id_PessoaFisica);
		
		if (professor != null){
			map.addAttribute("professor", professor);
		}
		
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
