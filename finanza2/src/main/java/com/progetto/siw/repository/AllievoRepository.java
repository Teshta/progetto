package com.progetto.siw.repository;

import org.springframework.data.repository.CrudRepository;

import com.progetto.siw.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long> {
	
	public Allievo findByNomeAndCognome(String nome,String cognome);
	
	public Allievo findOne(Long id);
	
	public Allievo delete(Long id);
}
