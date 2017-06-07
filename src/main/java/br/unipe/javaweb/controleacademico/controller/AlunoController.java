package br.unipe.javaweb.controleacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.javaweb.controleacademico.model.Aluno;
import br.unipe.javaweb.controleacademico.service.AlunoService;

@Controller
@RequestMapping(value="/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;		
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		map.addAttribute("alunos", alunoService.listar());
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
	
	@RequestMapping(value="/deletar/{id_pessoafisica}", method=RequestMethod.GET)
	public String deletar(@PathVariable("id_pessoafisica") Long id_pessoafisica, ModelMap map){
		Aluno aluno = alunoService.findById(id_pessoafisica);
		
		if (aluno != null){
			alunoService.deletar(aluno);
		}
		
		return "redirect:../listar";
	}		
	
}
