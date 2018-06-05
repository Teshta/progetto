package com.progetto.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value= {"/","/utente","/admin"})
	public String homepage(Model model) {
		return "";
	}
}
