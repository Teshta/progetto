package com.progetto.siw.controller;

import java.util.Optional;

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

	@GetMapping("/utente/newAllievo")
	public String mostraForm(Allievo allievo, 
			RedirectAttributes redir,
			Model model) {	
		String nextPage = "form";

		//		// Redirect se l'utente ha già registrato un atleta
		//		if (atletaService.hasUtenteGestore(username)) {
		//			redir.addFlashAttribute("erroreNewAtleta", "Hai già registrato il tuo profilo atleta, non puoi registrarne altri!");
		//			nextPage = "redirect:/utente/" + username;
		//		}

		model.addAttribute("navAllievi", "active");
		model.addAttribute("formAllievo",true);
		model.addAttribute("elencoCentri", centroService.findAll());
		return nextPage;
	}

	@PostMapping("/utente/newAllievo")
	public String checkAtletaInfo(@Valid @ModelAttribute Allievo allievo, 
			@RequestParam(defaultValue="") Long centroID, 
			@SessionAttribute(name="current_username") String username,
			BindingResult bindingResult, Model model) {
		String nextPage = "form";
		model.addAttribute("navAllievi", "active");
		model.addAttribute("formAllievo",true);

		if (!bindingResult.hasErrors()) {
			// controllo età minima

			if (!allievoService.isDuplicate(allievo)) {
				/* Attributi manipolati */
				allievo.setNome(allievo.getNome().toUpperCase());
				allievo.setCognome(allievo.getCognome().toUpperCase());

				/* Relazioni */
				if (centroID!=null)
					allievo.setCorso(corsoService.findById(centroID));
				else {
					model.addAttribute("corsoNonSelezionato", true);
				}

				// Service
				allievoService.save(allievo);

				model.addAttribute(allievo);
				model.addAttribute("successo", "Allievo registrato correttamente");
			} else {
				model.addAttribute("errore", "L'allievo è già presente nel sistema");
			}
		}	
		model.addAttribute("elencoCorsi", corsoService.findAll());
		return nextPage;
	}
}
