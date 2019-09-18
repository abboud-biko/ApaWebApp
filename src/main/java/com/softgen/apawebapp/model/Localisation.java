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
@Table(name="localisation")
public class Localisation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="pays")
    private String pays;
   
    @Column(name="ville")
    private String ville;
   
    @Column(name="latitude")
    private String latitude;
   
    @Column(name="longitude")
    private String longitude;
	
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

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
	
	
	
}
