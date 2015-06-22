package com.ninja_squad.geektic.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "id", sequenceName = "geek_seq")
@Table(name = "GEEK")
public class Geek {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@Column(name = "ID")
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "MAIL")
	private String mail;

	@Column(name = "GRAVATAR")
	private String urlGravatar;

	@Column(name = "SEXE")
	private String sexe;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "GEEK_INTERET", joinColumns = @JoinColumn(name = "IDGEEK"), inverseJoinColumns = @JoinColumn(name = "IDINTERET"))
	private Set<Interet> interets;

	public Set<Interet> getInterets() {
		return interets;
	}

	public void setInterets(Set<Interet> interets) {
		this.interets = interets;
	}

	public Geek() {
	}

	public Geek(String nom, String prenom, String mail, String urlGravatar,
			String sexe) {

		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.urlGravatar = urlGravatar;
		this.sexe = sexe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUrlGravatar() {
		return urlGravatar;
	}

	public void setUrlGravatar(String urlGravatar) {
		this.urlGravatar = urlGravatar;
	}

}
