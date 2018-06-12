package com.progetto.siw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.progetto.siw.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long> {
	
	public List<Allievo> findByNomeAndCognome(String nome,String cognome);
	
	public Optional<Allievo> findById(Long id);
	
	public void deleteById(Long id);
}
