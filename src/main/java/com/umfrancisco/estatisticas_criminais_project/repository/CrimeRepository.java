package com.umfrancisco.estatisticas_criminais_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;

public interface CrimeRepository extends JpaRepository<Crime, Long> {
	List<Crime> findByCidade(String cidade);
	List<Crime> findByCidadeAndPorHabitante(String cidade, Boolean porHabitante);
	List<Crime> findByAnoAndPorHabitante(Integer ano, Boolean porHabitante);
}
