package com.progetto.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="utenti")
public class Utente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String ruolo;
	
	@NotNull
	@Column(nullable = false)
	private boolean enabled;

	@OneToOne(mappedBy = "utente")
	private Centro centro;
	
	@OneToOne
	private Finanza finanza;

	public Utente(Long id, String username, String password, String ruolo) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled(){
		return enabled;
	}
	
	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
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
	
	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", password=" + password + ", Centro=" + centro + "]";
	}
}
