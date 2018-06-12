package com.progetto.siw.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.progetto.siw.model.Utente;
import com.progetto.siw.repository.UtenteRepository;

@Service
public class UtenteService{
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Utente findByUsername(String username) {
		return this.utenteRepository.findByUsername(username);
	}
	
	@Transactional
	public void save(final Utente utente) {		
		utente.setPassword(bCryptPasswordEncoder.encode(utente.getPassword()));
		utente.setEnabled(true);
		
		this.utenteRepository.save(utente);
	}
}
