package com.progetto.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.progetto.siw.model.Corso;

public interface CorsoRepository extends CrudRepository<Corso, String> {
	
	public Corso findByNome(String nome);

	public void deleteById(Long id);

	public List<Corso> findById(Long id);
}
