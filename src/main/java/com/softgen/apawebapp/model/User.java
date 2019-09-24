package com.softgen.apawebapp.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User{

	@Id
    @GeneratedValue(generator = "users_generator")
    @SequenceGenerator(
            name = "users_generator",
            sequenceName = "users_generator",
            initialValue = 1000
    )
    private Long id;
	 
    private String nom;
	 
    private String prenom;
	 
	@Column(unique=true)
    private String email;
	
    private String password;

	
	public User () {
		super();
	}
	public User (String nom , String prenom, String email, String password){
		this.nom = nom ;
		this.prenom = prenom; 
		this.email = email;
		this.password = password;
	}
	/** getters and setters **/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	}

