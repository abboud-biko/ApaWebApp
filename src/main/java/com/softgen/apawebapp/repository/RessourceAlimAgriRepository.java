package com.softgen.apawebapp.repository;

import com.softgen.apawebapp.model.RessourceAlimAgri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceAlimAgriRepository extends JpaRepository<RessourceAlimAgri, Long> {
}