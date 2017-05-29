package br.unipe.javaweb.controleacademico.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.javaweb.controleacademico.model.PessoaFisica;

@Controller
public class LoginController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String form (ModelMap map){
		PessoaFisica pessoa_fisica = new PessoaFisica();
		map.addAttribute("pessoa_fisica", pessoa_fisica);
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("pessoa_fisica") PessoaFisica pessoa_fisica, BindingResult result, ModelMap map, HttpSession session){
		return "redirect:mainpage";
	}
	
}
