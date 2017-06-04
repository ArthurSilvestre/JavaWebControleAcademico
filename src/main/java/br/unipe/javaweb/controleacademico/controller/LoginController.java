package br.unipe.javaweb.controleacademico.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.javaweb.controleacademico.model.Administrador;
import br.unipe.javaweb.controleacademico.model.Aluno;
import br.unipe.javaweb.controleacademico.model.PessoaFisica;
import br.unipe.javaweb.controleacademico.model.Professor;
import br.unipe.javaweb.controleacademico.service.AdministradorService;
import br.unipe.javaweb.controleacademico.service.AlunoService;
import br.unipe.javaweb.controleacademico.service.ProfessorService;

@Controller
public class LoginController {

	@Autowired
	private AdministradorService administradorService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private AlunoService alunoService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String form (ModelMap map){
		PessoaFisica usuario = new PessoaFisica();
		map.addAttribute("usuario", usuario);
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("usuario") PessoaFisica usuario_login, BindingResult result, ModelMap map, HttpSession session){
		
		PessoaFisica usuario = alunoService.findById(usuario_login.getId_PessoaFisica());
		
		if (usuario == null)
			usuario = professorService.findById(usuario_login.getId_PessoaFisica());
		
		if (usuario == null)
			usuario = administradorService.findById(usuario_login.getId_PessoaFisica());
		
		if (usuario == null){
			map.addAttribute("erro", "Matricula informada inválida.");
			return "login";
		}
			
		if (usuario.autenticar(usuario_login.getSenha())){
			session.setAttribute("usuario_autenticado", usuario);
			
			if (usuario instanceof Aluno){
				session.setAttribute("tipo_usuario", "Aluno");
				return "redirect:aluno/notas";
			} else if (usuario instanceof Professor){
				session.setAttribute("tipo_usuario", "Professor");
				return "redirect:professor/disciplinas";
			} else if (usuario instanceof Administrador){
				session.setAttribute("tipo_usuario", "Administrador");
				return "redirect:curso/listar";
			} else {
				map.addAttribute("erro", "Ocorreu um erro inesperado.");
				return "login";
			}
		} else {
			map.addAttribute("erro", "Senha informada inválida.");
			return "login";
		}
		
	}
	
}
