package com.softgen.apawebapp.repository;
import com.softgen.apawebapp.model.Image;
import com.softgen.apawebapp.model.RessourceAlimAgri;
import com.softgen.apawebapp.model.RessourceFaune;
import com.softgen.apawebapp.model.RessourceForestiere;
import com.softgen.apawebapp.model.RessourceMarine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	
	public List<Image> findByRessourceForestiere(RessourceForestiere ressourceForestiere);

	public List<Image> findByRessourceMarine(RessourceMarine ressourceMarine);

	public List<Image> findByRessourceFaune(RessourceFaune ressourceFaune);

	public List<Image> findByRessourceAlimAgri(RessourceAlimAgri ressourceAlimAgri);
	
}