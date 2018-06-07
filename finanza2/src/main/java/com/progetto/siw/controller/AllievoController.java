package com.progetto.siw.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.progetto.siw.model.Allievo;
import com.progetto.siw.service.AllievoService;

@Controller
//@SessionAttributes("current_username")
public class AllievoController {
	
	AllievoService allievoService;
	
	@GetMapping("/allievo/{id}")
	public String mostraAllievo(@PathVariable("id") Long id, Model model){
		Optional<Allievo> allievo = allievoService.findById(id);
		model.addAttribute("navAllievi", "active");
		model.addAttribute("allievo", allievo);
		return "view_allievo";
	}
	
	@PostMapping("/admin/deleteAllievo/{id}")
	public String eliminaAllievo(@PathVariable("id") Long id, 
			RedirectAttributes redir, Model model){
		allievoService.deleteById(id);
		redir.addFlashAttribute("successo", "L'allievo è stato rimosso dal sistema");
		return "redirect:/";
	}
}
