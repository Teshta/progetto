package com.progetto.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.progetto.siw.constant.Calcolatore;
import com.progetto.siw.model.Allievo;
import com.progetto.siw.service.AllievoService;
import com.progetto.siw.service.CentroService;
import com.progetto.siw.service.CorsoService;

@Controller
public class AllievoController {

	@Autowired
	AllievoService allievoService;

	@Autowired
	CentroService centroService;

	@Autowired
	CorsoService corsoService;

	@GetMapping("/allievo/{id}")
	public String mostraAllievo(@PathVariable("id") Long id, Model model){
		Allievo allievo = allievoService.findById(id);
		model.addAttribute("navAllievi", "active");
		model.addAttribute("allievo", allievo);
		return "view_allievo";
	}

	@GetMapping("admin/allievi")
	public String mostraCorsiCompletati(Model model) {
		model.addAttribute("navAllievi", "active");
		model.addAttribute("elencoAllievi", allievoService.findAll());
		return "view_allievi";
	}

	@GetMapping("/utente/newAllievo")
	public String mostraForm(Allievo allievo, 
			RedirectAttributes redir,
			Model model) {	
		String nextPage = "form";
		model.addAttribute("navAllievi", "active");
		model.addAttribute("formAllievo",true);
		model.addAttribute("elencoCentri", centroService.findAll());
		return nextPage;
	}

	@PostMapping("/utente/newAllievo")
	public String checkAllievoInfo(@Valid @ModelAttribute Allievo allievo, 
			@RequestParam(defaultValue="") Long centroID, 
			@SessionAttribute(name="current_username") String username,
			BindingResult bindingResult, Model model) {
		String nextPage = "form";
		model.addAttribute("navAllievi", "active");
		model.addAttribute("formAllievo",true);
		model.addAttribute("elencoCentri", centroService.findAll());

		if (!bindingResult.hasErrors()) {
			if (Calcolatore.convalidaEtaAllievo(allievo.getData())) {
				if (!allievoService.isDuplicate(allievo)) {

					allievo.setNome(allievo.getNome().toUpperCase());
					allievo.setCognome(allievo.getCognome().toUpperCase());

					if (centroID!=null)
						allievo.setCentro(centroService.findById(centroID));
					else {
						model.addAttribute("centroNonSelezionato", true);
					}

					allievoService.save(allievo);

					model.addAttribute(allievo);
					model.addAttribute("successo", "Allievo registrato correttamente");
				} else {
					model.addAttribute("errore", "L'allievo è già presente nel sistema");
				}
			} else
				model.addAttribute("errore", "La data di nascita è errata");
		}
		model.addAttribute("elencoCentri", centroService.findAll());
		return nextPage;
	}
	
	@PostMapping("/admin/deleteAllievo/{id}")
	public String eliminaAllievo(@PathVariable("id") Long id, 
			RedirectAttributes redir, Model model){
		//DA IMPLEMENTARE
		return "redirect:/";
	}
}