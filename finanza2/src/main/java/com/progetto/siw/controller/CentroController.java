package com.progetto.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.progetto.siw.model.Centro;
import com.progetto.siw.service.CentroService;

@Controller
@SessionAttributes
public class CentroController {
	
	@Autowired
	private CentroService centroService; 
	
	@GetMapping("/listCentri")
	public String mostraListaSocieta(Model model) {
		model.addAttribute("navCentri", "active");
		model.addAttribute("elencoCentri", centroService.findAll());
		return "view_centri";
	}
	
	@GetMapping("/listCentri/{id}")
	public String mostraCentri(@PathVariable("id") Long id, Model model){
		//Centro centro= centroService.findById(id);
		model.addAttribute("navCentri", "active");
		model.addAttribute("elencoCentri", centroService.findAll());
		model.addAttribute("centroPanel", true);
		//model.addAttribute("centro", centro);
		return "view_centri";
	}
}
