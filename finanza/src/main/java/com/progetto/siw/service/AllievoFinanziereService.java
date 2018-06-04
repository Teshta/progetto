package com.progetto.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progetto.siw.model.AllievoFinanziere;
import com.progetto.siw.repository.AllievoFinanziereRepository;

@Service
public class AllievoFinanziereService {
	
	@Autowired
	private AllievoFinanziereRepository allievoRepository;

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public AllievoFinanziere findByNomeAndCognome(String nome,String cognome) {
		return this.allievoRepository.findByNomeAndCognome(nome,cognome);
	}

	public boolean alreadyExists(String nome,String cognome) {
		return (this.allievoRepository.findByNomeAndCognome(nome,cognome)!=null);	
	}

	@Transactional
	public void save(final AllievoFinanziere allievo) {				
		this.allievoRepository.save(allievo);
}
}
