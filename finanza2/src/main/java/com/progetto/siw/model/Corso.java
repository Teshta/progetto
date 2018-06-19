package com.progetto.siw.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Corso implements Comparable<Corso>{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private LocalDate data;

//	@NumberFormat(pattern = "hh:mm")
//	@Column
//	private Time orario;
	
	@Column(nullable = false)
	private boolean completato;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Centro centroOperativo;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Allievo> allievi;

	public Corso() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

//	public Time getOrario() {
//		return orario;
//	}
//
//	public void setOrario(Time orario) {
//		this.orario = orario;
//	}
	
	public boolean isCompletato() {
		return completato;
	}
	public void setCompletato(boolean effettuato) {
		this.completato = effettuato;
	}

	public Centro getCentroOperativo() {
		return centroOperativo;
	}

	public void setCentroOperativo(Centro centroOperativo) {
		this.centroOperativo = centroOperativo;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	@Override
	public int compareTo(Corso o) {
		return this.getData().compareTo(o.getData());
	}	
}
