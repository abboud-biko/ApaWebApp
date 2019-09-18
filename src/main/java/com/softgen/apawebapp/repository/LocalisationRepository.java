package com.softgen.apawebapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.softgen.apawebapp.model.Localisation;
import com.softgen.apawebapp.model.RessourceAlimAgri;
import com.softgen.apawebapp.model.RessourceFaune;
import com.softgen.apawebapp.model.RessourceForestiere;
import com.softgen.apawebapp.model.RessourceMarine;

@Repository
public interface LocalisationRepository extends JpaRepository<Localisation, Long> {
	
	public List<Localisation> findByRessourceForestiere(RessourceForestiere ressourceForestiere);

	public List<Localisation> findByRessourceMarine(RessourceMarine ressourceMarine);

	public List<Localisation> findByRessourceFaune(RessourceFaune ressourceFaune);

	public List<Localisation> findByRessourceAlimAgri(RessourceAlimAgri ressourceAlimAgri);
	
}