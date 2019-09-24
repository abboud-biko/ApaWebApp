package com.softgen.apawebapp.repository;

import com.softgen.apawebapp.model.RessourceMarine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceMarineRepository extends JpaRepository<RessourceMarine, Long> {

	public RessourceMarine findById(long id);

	public void deleteById(long id);
}