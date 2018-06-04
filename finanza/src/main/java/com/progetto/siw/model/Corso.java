package com.progetto.siw.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Corso {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(nullable = false)
	private int orario;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private CentroOperativo centroOperativo;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<AllievoFinanziere> allieviFinanzieri;

	public Corso(Long id, String nome, Date data, int orario) {
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.orario = orario;
		this.allieviFinanzieri = new LinkedList<>();
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getOrario() {
		return orario;
	}

	public void setOrario(int orario) {
		this.orario = orario;
	}

	public CentroOperativo getCentroOperativo() {
		return centroOperativo;
	}

	public void setCentroOperativo(CentroOperativo centroOperativo) {
		this.centroOperativo = centroOperativo;
	}

	public List<AllievoFinanziere> getAllieviFinanzieri() {
		return allieviFinanzieri;
	}

	public void setAllieviFinanzieri(List<AllievoFinanziere> allieviFinanzieri) {
		this.allieviFinanzieri = allieviFinanzieri;
	}	
}
