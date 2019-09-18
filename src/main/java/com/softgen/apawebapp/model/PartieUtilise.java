package com.softgen.apawebapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="partie_utilise")
public class PartieUtilise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom")
    private String nom;
   
    @Column(name="description",columnDefinition="text")
    private String description;
   
    @Column(name="composition_chimique")
    private String compositionChimique;
    
    @Column(name="image_url")
    private String imageUrl;
	
	@ManyToOne
    @JoinColumn(name = "ressource_forestiere_id",nullable = true)
    private RessourceForestiere ressourceForestiere;
	
	@ManyToOne
    @JoinColumn(name = "ressource_marine_id",nullable = true)
    private RessourceMarine ressourceMarine;
	
	@ManyToOne
    @JoinColumn(name = "ressource_faune_id",nullable = true)
    private RessourceFaune ressourceFaune;
	
	@ManyToOne
    @JoinColumn(name = "ressource_alim_agri_id",nullable = true)
    private RessourceAlimAgri ressourceAlimAgri;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getCompositionChimique() {
		return compositionChimique;
	}

	public void setCompositionChimique(String compositionChimique) {
		this.compositionChimique = compositionChimique;
	}

	public RessourceMarine getRessourceMarine() {
		return ressourceMarine;
	}

	public void setRessourceMarine(RessourceMarine ressourceMarine) {
		this.ressourceMarine = ressourceMarine;
	}

	public RessourceForestiere getRessourceForestiere() {
		return ressourceForestiere;
	}

	public void setRessourceForestiere(RessourceForestiere ressourceForestiere) {
		this.ressourceForestiere = ressourceForestiere;
	}

	public RessourceFaune getRessourceFaune() {
		return ressourceFaune;
	}

	public void setRessourceFaune(RessourceFaune ressourceFaune) {
		this.ressourceFaune = ressourceFaune;
	}

	public RessourceAlimAgri getRessourceAlimAgri() {
		return ressourceAlimAgri;
	}

	public void setRessourceAlimAgri(RessourceAlimAgri ressourceAlimAgri) {
		this.ressourceAlimAgri = ressourceAlimAgri;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
