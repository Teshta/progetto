package com.progetto.siw.model;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class DirettoreGenerale {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String ruolo;

	@OneToOne
	private Finanza finanza;

	@OneToMany
	@JoinColumn(name = "direttoreGenerale_id")
	private List<CentroOperativo> centriOperativi;


	public DirettoreGenerale(Long id, String nome, String ruolo) {
		this.id = id;
		this.nome = nome;
		this.ruolo = ruolo;
		this.centriOperativi = new LinkedList<>();
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

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Finanza getFinanza() {
		return finanza;
	}

	public void setFinanza(Finanza finanza) {
		this.finanza = finanza;
	}

	public List<CentroOperativo> getCentriOperativi() {
		return centriOperativi;
	}

	public void setCentriOperativi(List<CentroOperativo> centriOperativi) {
		this.centriOperativi = centriOperativi;
	}	
}
