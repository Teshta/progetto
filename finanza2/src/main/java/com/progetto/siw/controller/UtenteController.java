package com.progetto.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.progetto.siw.model.Utente;
import com.progetto.siw.service.UtenteService;


@Controller
@SessionAttributes("current_username")
public class UtenteController {
	
	@Autowired
	private UtenteService responsabileUfficialeService;
	
	@RequestMapping("/accedi")
	public String accedi(@Valid @ModelAttribute Utente utente, Model model) {
		model.addAttribute("navAccesso", "active");
		return "accesso";
	}
	
}
