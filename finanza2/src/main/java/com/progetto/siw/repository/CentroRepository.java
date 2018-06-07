package com.progetto.siw.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.progetto.siw.model.Centro;

public interface CentroRepository  extends CrudRepository<Centro, Long>{
	
	public Centro findByNome(String nome);
	
	public Optional<Centro> findById(Long id);
	
	public void deleteById(Long id);
	
}
