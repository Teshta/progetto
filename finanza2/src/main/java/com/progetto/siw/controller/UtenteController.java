package com.progetto.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.progetto.siw.model.Utente;
import com.progetto.siw.service.CorsoService;
import com.progetto.siw.service.UtenteService;

@Controller
@SessionAttributes("current_username")
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private CorsoService corsoService;

	
	@RequestMapping("/accedi")
	public String accedi(@Valid @ModelAttribute Utente utente, Model model) {
		model.addAttribute("navAccesso", "active");
		return "accesso";
	}
	
	@GetMapping("/utente/{username}")
	public String mostraUtente(@PathVariable("username") String user, 
			@SessionAttribute(name="current_username") String username, Model model){
		Utente utente = utenteService.findByUsername(username);
		model.addAttribute("navAccesso", "active");
		model.addAttribute(utente);
		model.addAttribute("corsiAperti", corsoService.getCorsiAperti());
		model.addAttribute("corsiPassati", corsoService.getCorsiPassati());
		return "area_riservata";
	}
	
	@GetMapping("/admin/{username}")
	public String mostraAdmin(@PathVariable("username") String user, 
			@SessionAttribute(name="current_username") String username, Model model){
		Utente utente = utenteService.findByUsername(username);
		model.addAttribute("navAccesso", "active");
		model.addAttribute(utente);
		return "area_riservata";
	}
	
}
