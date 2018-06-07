package com.progetto.siw.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.siw.model.RuoloUtente;
import com.progetto.siw.repository.RuoloUtenteRepository;

@Service
public class RuoloUtenteService {
	
	@Autowired
	private RuoloUtenteRepository ruoloUtenteRepository;
	
	@Transactional
	public void add(final RuoloUtente ruoloUtente) {
		this.ruoloUtenteRepository.save(ruoloUtente);
	}
}
