package br.unipe.javaweb.controleacademico.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.javaweb.controleacademico.model.Aluno;
import br.unipe.javaweb.controleacademico.model.MatriculaTurma;
import br.unipe.javaweb.controleacademico.service.AlunoService;
import br.unipe.javaweb.controleacademico.service.MatriculaTurmaService;

@Controller
@RequestMapping(value="/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private MatriculaTurmaService matriculaTurmaService;	
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		map.addAttribute("alunos", alunoService.listar());
		return "aluno/listar";
	}
	
	@RequestMapping(value="/incluir", method=RequestMethod.GET)
	public String incluir(ModelMap map){
		
		Aluno aluno = new Aluno();
		
		map.addAttribute("aluno", aluno);		
		
		return "aluno/incluir";
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public String incluir(@ModelAttribute("aluno") Aluno aluno, BindingResult result, ModelMap map, HttpSession session){
		
		if (aluno.getId_PessoaFisica() == null){
			aluno.setSenha(alunoService.generateRandomPassword());
		}
		
		alunoService.salvar(aluno);
		return "redirect:listar";
	}	
	
	@RequestMapping(value="/editar/{id_PessoaFisica}", method=RequestMethod.GET)
	public String editar(@PathVariable("id_PessoaFisica") Long id_PessoaFisica, ModelMap map, HttpSession session){
		Aluno aluno = alunoService.findById(id_PessoaFisica);
		
		if (aluno != null){
			map.addAttribute("aluno", aluno);
		}
		
		return "aluno/editar";
	}	
	
	@RequestMapping(value="/notas", method=RequestMethod.GET)
	public String notas(ModelMap map, HttpSession session){
		
		List<MatriculaTurma> notasTurmas = matriculaTurmaService.obtemAlunos("2017.1", (Aluno)session.getAttribute("usuario_autenticado"));
		map.addAttribute("semestre", "2017.1");
		map.addAttribute("notas_turmas", notasTurmas);
		
		return "aluno/notas";
	}
	
	@RequestMapping(value="/historico", method=RequestMethod.GET)
	public String historico(ModelMap map, HttpSession session){
		
		List<MatriculaTurma> notasTurmas = matriculaTurmaService.obtemHistorico((Aluno)session.getAttribute("usuario_autenticado"));
		map.addAttribute("notas_turmas", notasTurmas);
		
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
