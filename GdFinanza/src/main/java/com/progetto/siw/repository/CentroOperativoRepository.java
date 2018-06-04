package com.progetto.siw.repository;

import org.springframework.data.repository.CrudRepository;

import com.progetto.siw.model.CentroOperativo;

public interface CentroOperativoRepository  extends CrudRepository<CentroOperativo, String>{
	
	public CentroOperativo findByNome(String nome);
}
