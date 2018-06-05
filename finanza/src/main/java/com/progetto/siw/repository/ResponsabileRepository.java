package com.progetto.siw.repository;

import org.springframework.data.repository.CrudRepository;

import com.progetto.siw.model.ResponsabileUfficiale;

public interface ResponsabileRepository extends CrudRepository<ResponsabileUfficiale,String > {
	
	public ResponsabileUfficiale findByNome(String nome);
}
