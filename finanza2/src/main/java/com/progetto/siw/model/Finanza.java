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

@Entity
public class Finanza {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;

	@OneToMany
	@JoinColumn(name = "finanza_responsabileUfficiale_id")
	private List<Utente> responsabiliUfficiali;

	@OneToMany
	@JoinColumn(name = "finanza_id")
	private List<Centro> centriOperativi;

	@OneToMany
	@JoinColumn(name = "finanza_id")
	private List<AllievoFinanziere> allieviFinanzieri;

	public Finanza(Long id, String nome) {
		this.id = id;
		this.centriOperativi = new LinkedList<>();
		this.allieviFinanzieri = new LinkedList<>();
		this.responsabiliUfficiali = new LinkedList<>();
		this.nome = nome;
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

	public List<Utente> getResponsabiliUfficiali() {
		return responsabiliUfficiali;
	}

	public void setResponsabiliUfficiali(List<Utente> responsabiliUfficiali) {
		this.responsabiliUfficiali = responsabiliUfficiali;
	}

	public List<Centro> getCentriOperativi() {
		return centriOperativi;
	}

	public void setCentriOperativi(List<Centro> centriOperativi) {
		this.centriOperativi = centriOperativi;
	}

	public List<AllievoFinanziere> getAllieviFinanzieri() {
		return allieviFinanzieri;
	}

	public void setAllieviFinanzieri(List<AllievoFinanziere> allieviFinanzieri) {
		this.allieviFinanzieri = allieviFinanzieri;
	}
}
