package com.softgen.apawebapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ressource_forestiere")
public class RessourceForestiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom_scientifique")
	private String nom_scientifique;
	
	@Column(name="nom_commun")
	private String nom_commun;
	
	@Column(name="discription",columnDefinition="text")
	private String discription;
	
	@Column(name="regne")
	private String regne;
	
	@Column(name="division")
	private String division;
	
	@Column(name="classe")
	private String classe;
	
	@Column(name="ordre")
	private String ordre;
	
	@Column(name="famille")
	private String famille;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="espece")
	private String espece;
	
	@Column(name="plante_longueur")
	private String plante_longueur;
	
	@Column(name="distribution",columnDefinition="text")
	private String distribution;
	
	@Column(name="image_url")
	private String image_url;


	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom_scientifique() {
		return nom_scientifique;
	}

	public void setNom_scientifique(String nom_scientifique) {
		this.nom_scientifique = nom_scientifique;
	}

	public String getNom_commun() {
		return nom_commun;
	}

	public void setNom_commun(String nom_commun) {
		this.nom_commun = nom_commun;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getRegne() {
		return regne;
	}

	public void setRegne(String regne) {
		this.regne = regne;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getOrdre() {
		return ordre;
	}

	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}

	public String getFamille() {
		return famille;
	}

	public void setFamille(String famille) {
		this.famille = famille;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getPlante_longueur() {
		return plante_longueur;
	}

	public void setPlante_longueur(String plante_longueur) {
		this.plante_longueur = plante_longueur;
	}

	public String getDistribution() {
		return distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

}