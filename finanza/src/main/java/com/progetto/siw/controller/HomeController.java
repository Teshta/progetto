package com.progetto.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.progetto.siw.model.ResponsabileUfficiale;
import com.progetto.siw.service.ResponsabileService;

@Controller
public class HomeController {

	@Autowired
	private ResponsabileService responsabileService;

	@GetMapping(value= {"/","/utente","/admin"})
	public String homepage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			ResponsabileUfficiale responsabile = responsabileService.findByNome(authentication.getName());
			model.addAttribute(responsabile);
			model.addAttribute("current_username", responsabile.getNome());
		}
		model.addAttribute("navHome", "active");
		return "home";
	}
}
