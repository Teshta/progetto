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
import com.progetto.siw.service.CentroService;
import com.progetto.siw.service.UtenteService;

@Controller
@SessionAttributes("current_username")
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private CentroService centroService;
	
	@RequestMapping("/accedi")
	public String accedi(@Valid @ModelAttribute Utente utente, Model model) {
		model.addAttribute("navAccesso", "active");
		return "accesso";
	}
	
	@GetMapping("/utente/{username}")
	public String mostraUtente(@PathVariable("username") String user, 
			@SessionAttribute(name="current_username") String username, Model model){
		Utente utente = utenteService.findByNome(username);
		
//		if (utente.hasAtletaGestito()) {
//			Atleta atleta = utente.getAtletaGestito();
//			
//			if (atleta.getSocieta()==null) {
//				model.addAttribute("elencoCentri", centroService.findAll());
//			} else if(!atleta.getRisultati().isEmpty()) {
//				model.addAttribute("risultatiGareNonSvolte", risultatoService.getRisultatiGareNonSvolte(atleta.getRisultati()));
//				model.addAttribute("risultatiGareSvolte", risultatoService.getRisultatiGareSvolte(atleta.getRisultati()));
//			}
//		}
		
		model.addAttribute("navAccesso", "active");
		model.addAttribute(utente);
		return "area_riservata";
	}
	
}
