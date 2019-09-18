package com.softgen.apawebapp.repository;

import com.softgen.apawebapp.model.RessourceForestiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceForestiereRepository extends JpaRepository<RessourceForestiere, Long> {
}