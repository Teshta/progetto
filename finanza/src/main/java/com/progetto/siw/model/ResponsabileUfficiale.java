package com.progetto.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ResponsabileUfficiale {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String ruolo;

	@OneToOne(mappedBy = "responsabileUfficiale")
	private CentroOperativo centroOperativo;
	
	@OneToOne
	private Finanza finanza;

	public ResponsabileUfficiale(Long id, String nome, String password, String ruolo) {
		this.id = id;
		this.nome = nome;
		this.password = password;
		this.ruolo = ruolo;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CentroOperativo getCentroOperativo() {
		return centroOperativo;
	}

	public void setCentroOperativo(CentroOperativo centroOperativo) {
		this.centroOperativo = centroOperativo;
	}

	public Finanza getFinanza() {
		return finanza;
	}

	public void setFinanza(Finanza finanza) {
		this.finanza = finanza;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}	
}
