package com.ninja_squad.geektic.model;

import java.util.Set;

import javax.persistence.*;


@Entity
@SequenceGenerator(name = "id", sequenceName = "interet_seq")
@Table(name = "INTERET")
public class Interet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@Column(name = "ID")
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToMany(mappedBy = "interets")
	private Set<Geek> Geeks;
    
	public Interet() {
	}

	public Interet(int id, String nom, String description) {
		this.id = id;
		this.nom = nom;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
