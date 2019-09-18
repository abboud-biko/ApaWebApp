package com.softgen.apawebapp.repository;

import com.softgen.apawebapp.model.RessourceFaune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceFauneRepository extends JpaRepository<RessourceFaune, Long> {
}