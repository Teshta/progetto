package com.progetto.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.progetto.siw.service.CorsoService;

public class CorsoController {
	
	@Autowired
	private CorsoService corsoService;
	
	@GetMapping("/corsi")
	public String mostraCorsiCompletati(Model model) {
		model.addAttribute("navCorsi", "active");
		model.addAttribute("corsiCompletati", corsoService.getCorsiCompletati());
		return "view_corsi";
	}
}
