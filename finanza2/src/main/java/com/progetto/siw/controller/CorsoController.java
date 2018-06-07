package com.progetto.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.progetto.siw.service.CorsoService;

@Controller
@SessionAttributes("current_username")
public class CorsoController {

	@Autowired
	private CorsoService corsoService;

	@GetMapping("/corsi")
	public String mostraCorsiCompletati(Model model) {
		model.addAttribute("navCorsi", "active");
		model.addAttribute("corsiPassati", corsoService.getCorsiPassati());
		model.addAttribute("corsiAperti", corsoService.getCorsiAperti());
		return "view_corsi";
	}
}
