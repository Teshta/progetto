package com.progetto.siw.repository;

import org.springframework.data.repository.CrudRepository;

import com.progetto.siw.model.Centro;

public interface CentroRepository  extends CrudRepository<Centro, Long>{
	
	public Centro findByNome(String nome);
	
}
