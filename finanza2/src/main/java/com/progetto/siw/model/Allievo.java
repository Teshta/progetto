package com.progetto.siw.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="allievo", uniqueConstraints = @UniqueConstraint(columnNames={"nome","cognome","dataNascita"}))
public class Allievo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private int telefono;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private LocalDate dataNascita;

	@Column(nullable = false)
	private String luogoNascita;

	@ManyToMany(mappedBy = "allieviFinanzieri")
	private List<Corso> corsi;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Centro centro;

	public Allievo(Long id, String nome, String cognome, String email, int telefono, LocalDate data, String luogoNascita) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.dataNascita = data;
		this.luogoNascita = luogoNascita;
		this.corsi = new LinkedList<>();
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public LocalDate getData() {
		return dataNascita;
	}

	public void setData(LocalDate data) {
		this.dataNascita = data;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public List<Corso> getCorso() {
		return corsi;
	}

	public void setCorso(List<Corso> corso) {
		this.corsi = corso;
	}	
	
	
}
