package com.softgen.apawebapp.repository;

import com.softgen.apawebapp.model.RessourceForestiere;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface RessourceForestiereRepository extends JpaRepository<RessourceForestiere, Long> {

	public RessourceForestiere findById(long id);

	public void deleteById(long id);

}