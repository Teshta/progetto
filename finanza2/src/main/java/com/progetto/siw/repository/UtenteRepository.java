package com.progetto.siw.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.progetto.siw.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, String > {
	
	public Utente findByUsername(String username);
	
	public Optional<Utente> findById(Long id);
}
