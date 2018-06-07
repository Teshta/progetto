package com.progetto.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.progetto.siw.model.Utente;
import com.progetto.siw.service.CorsoService;
import com.progetto.siw.service.UtenteService;

@Controller
@SessionAttributes("current_username")
public class CorsoController {

	@Autowired
	private CorsoService corsoService;
	
	@Autowired
	private UtenteService utenteService;

	@GetMapping("/corsi")
	public String mostraCorsiCompletati(Model model) {
		model.addAttribute("navCorsi", "active");
		model.addAttribute("corsiPassati", corsoService.getCorsiPassati());
		model.addAttribute("corsiAperti", corsoService.getCorsiAperti());
		return "view_corsi";
	}

//	@PostMapping("/utente/iscriviACorso/{id}")
//	public String iscriviAllievo(@PathVariable("id") Long id,
//			@SessionAttribute("current_username") String username,
//			RedirectAttributes redir, Model model) {
//		Utente utente = utenteService.findByNome(username);
//
//		// Errore: l'utente non ha un profilo atleta registrato
//		if (!utente.hasAtletaGestito()) {
//			redir.addFlashAttribute("errore", "Devi aver registrato un profilo atleta per partecipare alla gara.");
//		} else {
//			Atleta atleta = utente.getAtletaGestito();
//			// Errore: l'atleta non è iscritto ad una società
//			if (atleta.getSocieta()==null) {
//				redir.addFlashAttribute("errore", "Devi essere iscritto ad una società per partecipare alla gara.");
//			} else {
//				Gara gara = garaService.findOne(id);
//				Risultato risultato = new Risultato(atleta, gara);
//
//				// Errore: l'atleta è già iscritto alla gara
//				if (risultatoService.isAlreadyRegistered(risultato)) {
//					redir.addFlashAttribute("errore", "Sei già iscritto alla gara");
//
//				} else { 	// Scenario di successo
//					risultatoService.save(risultato);
//					redir.addFlashAttribute("successo", "Sei iscritto alla gara!");
//				}
//			}
//		}
//		return "redirect:/listGare";
//		}
}
