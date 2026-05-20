package com.umfrancisco.estatisticas_criminais_project.service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.umfrancisco.estatisticas_criminais_project.model.Cidade;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;
import com.umfrancisco.estatisticas_criminais_project.repository.CrimeRepository;
import com.umfrancisco.estatisticas_criminais_project.util.CsvFileParser;
import com.umfrancisco.estatisticas_criminais_project.util.Mapa;

@Service
public class CrimeService {
	
	private CrimeRepository repository;
	private Random random;
	
	public CrimeService(CrimeRepository repository) {
		this.repository = repository;
		random = new Random();
	}
	
	public void save(Crime crime) {
		repository.save(crime);
	}
	
	public List<Crime> findAll() {
		return repository.findAll();
	}
	
	public void saveData() throws IOException {
		Mapa mapa = new Mapa();
		
		Cidade campinas = new Cidade(random.nextLong(Long.MAX_VALUE), "Campinas", "SP", "campinas", "crime-stats-campinas.csv");
		Cidade ribeiraopreto = new Cidade(random.nextLong(Long.MAX_VALUE), "Ribeirão Preto", "SP", "ribeiraopreto", "crime-stats-ribeirao-preto.csv");
		Cidade saopaulo = new Cidade(random.nextLong(Long.MAX_VALUE), "São Paulo", "SP", "saopaulo", "crime-stats-sao-paulo.csv");
		
		CsvFileParser.read(mapa, campinas);
		CsvFileParser.read(mapa, ribeiraopreto);
		CsvFileParser.read(mapa, saopaulo);
		
		for (var crime : mapa.getCrimes()) {
			save(crime);
		}
	}
}
