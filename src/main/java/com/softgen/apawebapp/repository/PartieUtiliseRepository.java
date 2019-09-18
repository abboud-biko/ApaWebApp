package com.softgen.apawebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import com.softgen.apawebapp.model.PartieUtilise;
import com.softgen.apawebapp.model.RessourceAlimAgri;
import com.softgen.apawebapp.model.RessourceFaune;
import com.softgen.apawebapp.model.RessourceForestiere;
import com.softgen.apawebapp.model.RessourceMarine;

@Repository
public interface PartieUtiliseRepository extends JpaRepository<PartieUtilise, Long> {
	
	public List<PartieUtilise> findByRessourceForestiere(RessourceForestiere ressourceForestiere);

	public List<PartieUtilise> findByRessourceMarine(RessourceMarine ressourceMarine);

	public List<PartieUtilise> findByRessourceFaune(RessourceFaune ressourceFaune);

	public List<PartieUtilise> findByRessourceAlimAgri(RessourceAlimAgri ressourceAlimAgri);
	
}