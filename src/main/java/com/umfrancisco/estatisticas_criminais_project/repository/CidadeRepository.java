package com.umfrancisco.estatisticas_criminais_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.estatisticas_criminais_project.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	Cidade findByNomeCidadeUrl(String nomeCidadeUrl);
}
