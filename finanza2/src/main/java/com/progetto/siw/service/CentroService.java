package com.progetto.siw.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progetto.siw.model.Centro;
import com.progetto.siw.repository.CentroRepository;

@Transactional
@Service
public class CentroService {

	@Autowired
	private CentroRepository centroRepository;

	public Iterable<Centro> findAll(){
		return this.centroRepository.findAll();
	}

	public Centro findById(Long id) {
		Optional<Centro> centro = this.centroRepository.findById(id);
		if (centro.isPresent()) 
			return centro.get();
		else
			return null;
	}

	public void deleteById(Long id) {
		centroRepository.deleteById(id);
	}

	public void save(@Valid Centro centro) {
		this.centroRepository.save(centro);
	}

	public boolean isDuplicateSameName(@Valid Centro centro) {
		Iterable<Centro> centri = this.centroRepository.findAll();
		for (Centro g : centri) {
			if (g.getNome().equals(centro.getNome().toUpperCase()))
				return true;
		}
		return false;
	}
}
