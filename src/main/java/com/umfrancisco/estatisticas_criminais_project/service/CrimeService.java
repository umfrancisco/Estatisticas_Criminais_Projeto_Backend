package com.umfrancisco.estatisticas_criminais_project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;
import com.umfrancisco.estatisticas_criminais_project.model.CrimeDTO;
import com.umfrancisco.estatisticas_criminais_project.model.Infracao;
import com.umfrancisco.estatisticas_criminais_project.repository.CrimeRepository;
import com.umfrancisco.estatisticas_criminais_project.util.CsvFileParser;
import com.umfrancisco.estatisticas_criminais_project.util.Mapa;

@Service
public class CrimeService {
	
	private CrimeRepository repository; 
	
	public CrimeService(CrimeRepository repository) {
		this.repository = repository;
	}
	
	public void save(Crime taxaDelito) {
		repository.save(taxaDelito);
	}
	
	public List<Crime> findAll() {
		return repository.findAll();
	}
	
	public List<Crime> findByCidade(String cidade) {
		return repository.findByCidade(cidade);
	}
	
	public List<Crime> findByAnoAndPorHabitante(Integer ano, Boolean porHabitante) {
		return repository.findByAnoAndPorHabitante(ano, porHabitante);
	}
	
	public List<CrimeDTO> findByCidadeAndInfracao(String cidade, Infracao infracao, Boolean porHabitante) {
		List<Crime> list = repository.findByCidadeAndPorHabitante(cidade, porHabitante);
		List<CrimeDTO> found = new ArrayList<>();
		for (var c : list) {
			if (c.getCidade().equals(cidade)) {
				String nomeCidade = c.getCidade();
				Integer ano = c.getAno();
				Double valorInfracao = null;
				switch (infracao) {
					case HOMICIDIO -> valorInfracao = c.getHomicidio();
					case FURTO -> valorInfracao = c.getFurto();
					case ROUBO -> valorInfracao = c.getRoubo();
					case FURTO_ROUBO_VEICULO -> valorInfracao = c.getFurtoRouboVeiculos();
					default -> valorInfracao = null;
				}
				found.add(new CrimeDTO(nomeCidade, ano, infracao, valorInfracao));
			}
		}
		return found;
	}
	
	public void saveDataFromCsvFile() throws IOException {
		Mapa mapa = new Mapa();
		String[] cidades = {
				"bauru", 
				"campinas", 
				"presidenteprudente", 
				"ribeiraopreto",
				"santos",
				"saocarlos",
				"saopaulo",
				"sorocaba"
		};
		for (String cidade : cidades) {
			CsvFileParser.read(mapa, cidade, "data/taxa-delito-%s.csv", true);
			CsvFileParser.read(mapa, cidade, "data/ocorrencias-%s.csv", false);
		}
		for (var c : mapa.getCrimes()) {
			save(c);
		}
	}
}
