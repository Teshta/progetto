package com.progetto.siw.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.siw.model.RuoloUtente;
import com.progetto.siw.repository.RuoloUtenteRepository;

@Transactional
@Service
public class RuoloUtenteService {
	
	@Autowired
	private RuoloUtenteRepository ruoloUtenteRepository;
	
	public void add(final RuoloUtente ruoloUtente) {
		this.ruoloUtenteRepository.save(ruoloUtente);
	}
}
