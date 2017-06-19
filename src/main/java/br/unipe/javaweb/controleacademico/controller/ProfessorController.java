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

import br.unipe.javaweb.controleacademico.model.ListOfMatriculaTurma;
import br.unipe.javaweb.controleacademico.model.MatriculaTurma;
import br.unipe.javaweb.controleacademico.model.Professor;
import br.unipe.javaweb.controleacademico.model.Turma;
import br.unipe.javaweb.controleacademico.service.MatriculaTurmaService;
import br.unipe.javaweb.controleacademico.service.ProfessorService;
import br.unipe.javaweb.controleacademico.service.TurmaService;

@Controller
@RequestMapping(value="/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private TurmaService turmaService;	
	
	@Autowired
	private MatriculaTurmaService matriculaTurmaService;		
	
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
		
		if (professor.getId_PessoaFisica() == null){
			professor.setSenha(professorService.generateRandomPassword());
		}		
		
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
	public String disciplinas(ModelMap map, HttpSession session){
		
		List<Turma> turmas = turmaService.obtemTurmasPorProfessorESemestre("2017.1", (Professor) session.getAttribute("usuario_autenticado"));
		
		map.addAttribute("semestre","2017.1");
		map.addAttribute("turmas",turmas);
		
		return "professor/disciplinas";
	}
	
	@RequestMapping(value="/lancarnotas/{id_Turma}", method=RequestMethod.GET)
	public String lancarnotas(@PathVariable("id_Turma") Long id_Turma, ModelMap map, HttpSession session){
		
		Turma turma = turmaService.findById(id_Turma);
		
		if (turma != null){
			List<MatriculaTurma> alunosMatriculados = matriculaTurmaService.obtemAlunos(turma);
			
			for (MatriculaTurma matriculaTurma : alunosMatriculados) {
				matriculaTurma.addListener(matriculaTurma.getAluno());
			}
			
			ListOfMatriculaTurma listOfMatriculaTurma = new ListOfMatriculaTurma();
			listOfMatriculaTurma.setMatriculaTurmas(alunosMatriculados);
			
			map.addAttribute("list_of_matricula_turma", listOfMatriculaTurma);
		}
		
		return "professor/lancarnotas";
	}
	
	@RequestMapping(value="/salvarnotas", method=RequestMethod.POST)
	public String salvarnotas(@ModelAttribute("list_of_matricula_turma") ListOfMatriculaTurma listOfMatriculaTurma, BindingResult result, ModelMap map){
		matriculaTurmaService.saveAll(listOfMatriculaTurma.getMatriculaTurmas());
		return "redirect:../professor/disciplinas";
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
