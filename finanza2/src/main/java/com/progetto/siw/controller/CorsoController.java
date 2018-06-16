package com.progetto.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.progetto.siw.constant.Calcolatore;
import com.progetto.siw.model.Corso;
import com.progetto.siw.model.Utente;
import com.progetto.siw.service.CentroService;
import com.progetto.siw.service.CorsoService;
import com.progetto.siw.service.UtenteService;

@Controller
@SessionAttributes("current_username")
public class CorsoController {

	@Autowired
	private CorsoService corsoService;
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private CentroService centroService;

	@GetMapping("/corsi")
	public String mostraCorsiCompletati(Model model) {
		model.addAttribute("navCorsi", "active");
		model.addAttribute("corsiPassati", corsoService.getCorsiPassati());
		model.addAttribute("corsiAperti", corsoService.getCorsiAperti());
		return "view_corsi";
	}
	
	@GetMapping("/corso/{id}")
	public String mostraCorso(@PathVariable("id") Long id, Model model){
		Corso corso = corsoService.findById(id);
		model.addAttribute("navCorsi", "active");
//		model.addAttribute("corsiAperti", corsoService.getCorsiAperti());
		model.addAttribute("corsoPanel", true);
		model.addAttribute("corso", corso);
		return "view_corso";
	}
	
	@GetMapping("/utente/newCorso")
	public String mostraForm(Corso corso, Model model) {
		model.addAttribute("navCorsi", "active");
		model.addAttribute("formCorso", true);
		model.addAttribute("elencoCentri", centroService.findAll());
		return "form";
	}
	
	@PostMapping("/utente/newCorso")
	public String checkCorsoInfo(@Valid @ModelAttribute Corso corso,Long centroID, BindingResult bindingResult, Model model) {
		String nextPage = "form";
		model.addAttribute("navCorsi", "active");
		model.addAttribute("formCorso", true);

		if (!bindingResult.hasErrors()) {
			// controllo data futura
//			if (Calcolatore.convalidaDataCorso(corso.getData())) {
				// controllo corso esistente nello stesso giorno
				if (!corsoService.isDuplicateSameDate(corso)) {
					/*Attributi manipolati*/
					corso.setNome(corso.getNome().toUpperCase());
					if (centroID!=null)
						corso.setCentroOperativo(centroService.findById(centroID));  //col post assegno al corso un centro
					corsoService.save(corso);

					model.addAttribute(corso);
					model.addAttribute("successo", "Corso registrato correttamente");
				} else {
					model.addAttribute("errore", "È già presente un corso per quella data");
				}
//			} else {
//				model.addAttribute("errore", "Inserire una data valida (non quella odierna)");
//			}
		}
		return nextPage;
	}

//	@PostMapping("/utente/iscriviACorso/{id}")
//	public String iscriviAllievo(@PathVariable("id") Long id,
//			@SessionAttribute("current_username") String username,
//			RedirectAttributes redir, Model model) {
//		Utente utente = utenteService.findByNome(username);
//
//		// Errore: l'allievo non è registrato
//		if (!utente.hasAtletaGestito()) {
//			redir.addFlashAttribute("errore", "L'allievo deve essere registrato al centro per poter partecipare ad un corso.");
//		} else {
//			Allievo allievo = utente.getAllievoGestito();
//			// Errore: l'atleta non è iscritto ad una società
//			if (atleta.getSocieta()==null) {
//				redir.addFlashAttribute("errore", "Devi essere iscritto ad una società per partecipare alla gara.");
//			} else {
//				Gara gara = garaService.findOne(id);
//				Risultato risultato = new Risultato(atleta, gara);
//
//				// Errore: l'atleta è già iscritto al corso
//				if (risultatoService.isAlreadyRegistered(risultato)) {
//					redir.addFlashAttribute("errore", "L'allievo è già iscritto al corso");
//
//				} else { 	// Scenario di successo
//					risultatoService.save(risultato);
//					redir.addFlashAttribute("successo", "L'allievo è stato iscritto al corso!");
//				}
//			}
//		}
//		return "redirect:/listCorsi";
//		}
	
	@Transactional
	@PostMapping("/admin/deleteCorso/{id}")
	public String eliminaCorso(@PathVariable("id") Long id, 
			RedirectAttributes redir, Model model){
		corsoService.deleteById(id);
		redir.addFlashAttribute("successo", "Il corso è stato rimosso dal sistema");
		return "redirect:/listCorsi";
	}
}
