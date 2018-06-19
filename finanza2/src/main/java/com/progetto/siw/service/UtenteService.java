package com.progetto.siw.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.progetto.siw.model.RuoloUtente;
import com.progetto.siw.model.Utente;
import com.progetto.siw.repository.UtenteRepository;

@Transactional
@Service
public class UtenteService{
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Utente findByUsername(String username) {
		return this.utenteRepository.findByUsername(username);
	}
	
	public void save(final Utente utente) {		
		utente.setPassword(bCryptPasswordEncoder.encode(utente.getPassword()));
		utente.setEnabled(true);
		
		this.utenteRepository.save(utente);
	}
	
	public Utente findById(Long id) {
		Optional<Utente> utente = this.utenteRepository.findById(id);
		if (utente.isPresent()) 
			return utente.get();
		else
			return null;
	}
	
	public Iterable<Utente> findAll() {
		return utenteRepository.findAll();
	}
	
	public List<Utente> utentiSenzaCentro(){
		Iterable<Utente> elencoUtenti = utenteRepository.findAll();
		List<Utente> utentiSenzaCentro = new LinkedList<>();
		for(Utente u : elencoUtenti){
			if (u.getCentro() == null)
					utentiSenzaCentro.add(u);
		}
		Collections.sort(utentiSenzaCentro);
		return utentiSenzaCentro;
	}
}
