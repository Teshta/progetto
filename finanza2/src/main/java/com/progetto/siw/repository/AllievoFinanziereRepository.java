package com.progetto.siw.repository;

import org.springframework.data.repository.CrudRepository;

import com.progetto.siw.model.AllievoFinanziere;

public interface AllievoFinanziereRepository extends CrudRepository<AllievoFinanziere, String> {
	
	public AllievoFinanziere findByNomeAndCognome(String nome,String cognome);
}
