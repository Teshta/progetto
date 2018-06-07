package com.progetto.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.siw.model.Centro;
import com.progetto.siw.repository.CentroRepository;

@Service
public class CentroService {
	
	@Autowired
	private CentroRepository centroRepository;
	
	public Iterable<Centro> findAll(){
		return this.centroRepository.findAll();
	}
	
	public Centro findOne(Long id) {
    	return this.centroRepository.findOne(id);
    }
	
	 public void deleteById(Long id) {
	    	centroRepository.delete(id);
	    }
}
