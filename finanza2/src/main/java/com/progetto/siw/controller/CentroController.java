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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.progetto.siw.model.Centro;
import com.progetto.siw.service.CentroService;
import com.progetto.siw.service.UtenteService;

@Controller
@SessionAttributes
public class CentroController {
	
	@Autowired
	private CentroService centroService; 
	
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping("/listCentri")
	public String mostraListaCentri(Model model) {
		model.addAttribute("navCentri", "active");
		model.addAttribute("elencoCentri", centroService.findAll());
		return "view_centri";
	}
	
	@GetMapping("admin/listCentri/{id}")
	public String mostraCentri(@PathVariable("id") Long id, Model model){
		Centro centro= centroService.findById(id);
		model.addAttribute("navCentri", "active");
		model.addAttribute("elencoCentri", centroService.findAll());
		model.addAttribute("centroPanel", true);
		model.addAttribute("centro", centro);
		return "view_centri";
	}
	
	@GetMapping("/admin/newCentro")
	public String mostraForm(Centro centro, Model model) {
		model.addAttribute("navCentri", "active");
		model.addAttribute("formCentro", true);
		model.addAttribute("elencoUtenti", utenteService.utentiSenzaCentro());
		return "form";
	}
	
	@PostMapping("/admin/newCentro")
	public String checkCorsoInfo(@Valid @ModelAttribute Centro centro,Long utenteID, BindingResult bindingResult, Model model) {
		String nextPage = "form";
		model.addAttribute("navCentri", "active");
		model.addAttribute("formCentro", true);
		model.addAttribute("elencoUtenti", utenteService.utentiSenzaCentro());

		if (!bindingResult.hasErrors()) {
				if (!centroService.isDuplicateSameName(centro)) {
					centro.setNome(centro.getNome().toUpperCase());
					if (utenteID!=null)
						centro.setUtente(utenteService.findById(utenteID));
					centroService.save(centro);

					model.addAttribute(centro);
					model.addAttribute("successo", "Centro registrato correttamente");
				} else {
					model.addAttribute("errore", "È già presente un centro con questo nome");
				}
		}
		return nextPage;
	}
	
	@PostMapping("/admin/deleteCentro/{id}")
	public String eliminaCentro(@PathVariable("id") Long id, 
			RedirectAttributes redir, Model model){
		return "redirect:/listCentri";
	}
}
