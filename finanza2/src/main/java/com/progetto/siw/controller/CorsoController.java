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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.progetto.siw.model.Corso;
import com.progetto.siw.service.CentroService;
import com.progetto.siw.service.CorsoService;

@Controller
@SessionAttributes("current_username")
public class CorsoController {

	@Autowired
	private CorsoService corsoService;
	
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
		model.addAttribute("elencoCentri", centroService.findAll());

		if (!bindingResult.hasErrors()) {
				// controllo corso esistente nello stesso giorno
				if (!corsoService.isDuplicateSameDate(corso)) {
					corso.setNome(corso.getNome().toUpperCase());
					if (centroID!=null)
						corso.setCentroOperativo(centroService.findById(centroID)); 
					corsoService.save(corso);

					model.addAttribute(corso);
					model.addAttribute("successo", "Corso registrato correttamente");
				} else {
					model.addAttribute("errore", "È già presente un corso per quella data");
				}
		}
		return nextPage;
	}
	
	@Transactional
	@PostMapping("/admin/deleteCorso/{id}")
	public String eliminaCorso(@PathVariable("id") Long id, 
			RedirectAttributes redir, Model model){
		return "redirect:/";
	}
}
