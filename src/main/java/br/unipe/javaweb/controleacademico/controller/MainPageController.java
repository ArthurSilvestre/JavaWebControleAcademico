package br.unipe.javaweb.controleacademico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

	@RequestMapping(value="/mainpage", method = RequestMethod.GET)
	public String form(ModelMap map){
		return "mainpage";
	}
	
}
