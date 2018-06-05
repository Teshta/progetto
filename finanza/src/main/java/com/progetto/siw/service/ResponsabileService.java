package com.progetto.siw.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.progetto.siw.model.ResponsabileUfficiale;
import com.progetto.siw.repository.ResponsabileRepository;

public class ResponsabileService{
	
	@Autowired
	private ResponsabileRepository responsabile;
	
	public ResponsabileUfficiale findByNome(String nome) {
		return this.responsabile.findByNome(nome);
	}
}
