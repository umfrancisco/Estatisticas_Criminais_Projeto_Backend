package com.umfrancisco.estatisticas_criminais_project.service;

import org.springframework.stereotype.Service;

import com.umfrancisco.estatisticas_criminais_project.model.Cidade;
import com.umfrancisco.estatisticas_criminais_project.repository.CidadeRepository;

@Service
public class CidadeService {
	
	private CidadeRepository repository;
	
	public CidadeService(CidadeRepository repository) {
		this.repository = repository;
	}
	
	public void save(Cidade... cidades) {
		for (var c : cidades) {
			repository.save(c);
		}
	}
	
}
