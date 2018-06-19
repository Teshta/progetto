package com.progetto.siw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progetto.siw.model.Allievo;
import com.progetto.siw.repository.AllievoRepository;

@Transactional
@Service
public class AllievoService {

	@Autowired
	private AllievoRepository allievoRepository;

	public List<Allievo> findByNomeAndCognome(String nome,String cognome) {
		return this.allievoRepository.findByNomeAndCognome(nome,cognome);
	}

	public boolean alreadyExists(String nome,String cognome) {
		return (this.allievoRepository.findByNomeAndCognome(nome,cognome)!=null);	
	}

	public Allievo findById(Long id) {
		Optional<Allievo> allievo = this.allievoRepository.findById(id);
		if (allievo.isPresent()) 
			return allievo.get();
		else
			return null;
	}

	public void deleteById(Long id) {
		this.allievoRepository.deleteById(id);
	}

	public boolean isDuplicate(final Allievo allievo) {
		List<Allievo> allievi = (List<Allievo>) this.allievoRepository.findAll();
		for (Allievo a : allievi) {
			if (a.getNome().equals(allievo.getNome().toUpperCase()) && a.getCognome().equals(allievo.getCognome().toUpperCase()) && a.getData().equals(allievo.getData()))
				return true;
		}
		return false;
	}

	public void save(final Allievo allievo) {				
		this.allievoRepository.save(allievo);
	}

	public Iterable<Allievo> findAll() {
		return this.allievoRepository.findAll();
	}
}
