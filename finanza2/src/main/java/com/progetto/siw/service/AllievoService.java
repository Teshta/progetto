package com.progetto.siw.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progetto.siw.model.Allievo;
import com.progetto.siw.repository.AllievoRepository;

@Service
public class AllievoService {
	
	@Autowired
	private AllievoRepository allievoRepository;

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Allievo findByNomeAndCognome(String nome,String cognome) {
		return this.allievoRepository.findByNomeAndCognome(nome,cognome);
	}

	public boolean alreadyExists(String nome,String cognome) {
		return (this.allievoRepository.findByNomeAndCognome(nome,cognome)!=null);	
	}
	
	public Optional<Allievo> findById(Long id) {
    	return this.allievoRepository.findById(id);
    }
	
	public void deleteById(Long id) {
    	this.allievoRepository.deleteById(id);
    }

	@Transactional
	public void save(final Allievo allievo) {				
		this.allievoRepository.save(allievo);
}
}
