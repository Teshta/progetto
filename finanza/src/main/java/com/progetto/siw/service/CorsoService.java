package com.progetto.siw.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.siw.Calcolatore;
import com.progetto.siw.model.Corso;
import com.progetto.siw.repository.CorsoRepository;

@Service
public class CorsoService {
	
	@Autowired
	private CorsoRepository corsoRepository;
	
	public Iterable<Corso> findAll(){
		return this.corsoRepository.findAll();
	}
	
	public List<Corso> sortedByData(){
		Iterable<Corso> elencoCorsi = findAll();
		List<Corso> corsi = new LinkedList<>();
		for(Corso g : elencoCorsi){
			corsi.add(g);
		}
		Collections.sort(corsi);
		return corsi;
	}
	
	public List<Corso> getCorsiCompletati() {
		Iterable<Corso> corsi= sortedByData();
		List<Corso> corsiCompletati = new ArrayList<>();
		for (Corso corso: corsi) {
			if (Calcolatore.isDataPassata(corso.getData()))
				corsiCompletati.add(corsi);
		}
		return corsiCompletati;
	}
}
