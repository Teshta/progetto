package com.progetto.siw.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progetto.siw.constant.Calcolatore;
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
				corsiCompletati.add(corso);
		}
		return corsiCompletati;
	}
	
	public List<Corso> getCorsiAperti() {
		Iterable<Corso> corsi = sortedByData();
		List<Corso> corsiAperti = new ArrayList<>();
		for (Corso corso: corsi) {
			if (!Calcolatore.isDataPassata(corso.getData()) && (!corso.isCompletato()))
				corsiAperti.add(corso);
		}
		return corsiAperti;
	}
	
	public List<Corso> getCorsiPassati() {
		Iterable<Corso> allcorsi = sortedByData();
		List<Corso> corsiPassati = new ArrayList<>();
		for (Corso corso: allcorsi) {
			if (Calcolatore.isDataPassata(corso.getData()))
				corsiPassati.add(corso);
		}
		return corsiPassati;
	}
	
	public boolean isDuplicateSameDate(final Corso corso) {
		Iterable<Corso> corsi = this.corsoRepository.findAll();
		for (Corso g : corsi) {
			if (g.getData().equals(corso.getData()))
				return true;
		}
		return false;
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.corsoRepository.deleteById(id);
	}
	
	@Transactional
	public void save(final Corso corso) {
		this.corsoRepository.save(corso);
	}

	public List<Corso> findById(Long id) {
		return this.corsoRepository.findById(id);
	}
}
