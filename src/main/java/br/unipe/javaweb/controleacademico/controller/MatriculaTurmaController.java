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

import br.unipe.javaweb.controleacademico.model.MatriculaTurma;
import br.unipe.javaweb.controleacademico.model.Turma;
import br.unipe.javaweb.controleacademico.service.AlunoService;
import br.unipe.javaweb.controleacademico.service.MatriculaTurmaService;
import br.unipe.javaweb.controleacademico.service.TurmaService;

@Controller
@RequestMapping(value="/matriculaTurma")
public class MatriculaTurmaController {

	@Autowired
	private AlunoService alunoService;	
	
	@Autowired
	private MatriculaTurmaService matriculaTurmaService;
	
	@Autowired
	private TurmaService turmaService;	
	
	@RequestMapping(value="/matricular/{id_turma}", method=RequestMethod.GET)
	public String matricular(@PathVariable("id_turma") Long id_turma, ModelMap map, HttpSession session){

		Turma turma = turmaService.findById(id_turma);
		
		if (turma != null){
			MatriculaTurma matricula_turma = new MatriculaTurma();
			matricula_turma.setTurma(turma);
			
			map.addAttribute("matricula_turma", matricula_turma);
			map.addAttribute("alunos", alunoService.listar());
		}		
		
		return "turma/matricular";
	}
	
	@RequestMapping(value="/matricular", method=RequestMethod.POST)
	public String matricular(@ModelAttribute("matricula_turma") MatriculaTurma matricula_turma, BindingResult result, ModelMap map, HttpSession session){
		
		matriculaTurmaService.salvar(matricula_turma);
		
		return "redirect:../turma/listar";
	}
	
}
