package com.umfrancisco.estatisticas_criminais_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;

public interface CrimeRepository extends JpaRepository<Crime, Long> {
	
}
