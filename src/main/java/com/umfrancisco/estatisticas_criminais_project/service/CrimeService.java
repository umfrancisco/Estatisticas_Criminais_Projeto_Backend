package com.umfrancisco.estatisticas_criminais_project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import com.umfrancisco.estatisticas_criminais_project.model.Cidade;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;
import com.umfrancisco.estatisticas_criminais_project.model.CrimeDTO;
import com.umfrancisco.estatisticas_criminais_project.model.Infracao;
import com.umfrancisco.estatisticas_criminais_project.repository.CrimeRepository;
import com.umfrancisco.estatisticas_criminais_project.util.CsvFileParser;
import com.umfrancisco.estatisticas_criminais_project.util.Mapa;

@Service
public class CrimeService {
	
	private CrimeRepository repository;
	private CidadeService cidadeService;
	private Random random;
	
	public CrimeService(CrimeRepository repository, CidadeService cidadeService) {
		this.repository = repository;
		this.cidadeService = cidadeService;
		random = new Random();
	}
	
	public void save(Crime crime) {
		repository.save(crime);
	}
	
	public List<Crime> findAll() {
		return repository.findAll();
	}
	
	public List<Crime> findByCidade(String cidade) {
		List<Crime> list = findAll();
		List<Crime> found = new ArrayList<>();
		for (var c : list) {
			if (c.getCidade().getNomeCidadeUrl().equals(cidade)) {
				found.add(c);
			}
		}
		return found;
	}
	
	public List<CrimeDTO> findByCidadeAndInfracao(String cidade, Infracao infracao) {
		List<Crime> list = findAll();
		List<CrimeDTO> found = new ArrayList<>();
		for (var c : list) {
			if (c.getCidade().getNomeCidadeUrl().equals(cidade)) {
				String nomeCidade = c.getCidade().getCidade();
				Integer ano = c.getAno();
				Integer valorInfracao = null;
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
		
		Cidade bauru = new Cidade(random.nextLong(Long.MAX_VALUE), "Bauru", "SP", "bauru");
		Cidade campinas = new Cidade(random.nextLong(Long.MAX_VALUE), "Campinas", "SP", "campinas");
		Cidade presidenteprudente = new Cidade(random.nextLong(Long.MAX_VALUE), "Presidente Prudente", "SP", "presidenteprudente");
		Cidade ribeiraopreto = new Cidade(random.nextLong(Long.MAX_VALUE), "Ribeirão Preto", "SP", "ribeiraopreto");
		Cidade santos = new Cidade(random.nextLong(Long.MAX_VALUE), "Santos", "SP", "santos");
		Cidade saocarlos = new Cidade(random.nextLong(Long.MAX_VALUE), "São Carlos", "SP", "saocarlos");
		Cidade saopaulo = new Cidade(random.nextLong(Long.MAX_VALUE), "São Paulo", "SP", "saopaulo");
		Cidade sorocaba = new Cidade(random.nextLong(Long.MAX_VALUE), "Sorocaba", "SP", "sorocaba");
		cidadeService.save(bauru, campinas, presidenteprudente, ribeiraopreto, santos, saocarlos, saopaulo, sorocaba);
		
		CsvFileParser.read(mapa, bauru);
		CsvFileParser.read(mapa, campinas);
		CsvFileParser.read(mapa, presidenteprudente);
		CsvFileParser.read(mapa, ribeiraopreto);
		CsvFileParser.read(mapa, santos);
		CsvFileParser.read(mapa, saocarlos);
		CsvFileParser.read(mapa, saopaulo);
		CsvFileParser.read(mapa, sorocaba);
		
		for (var crime : mapa.getCrimes()) {
			save(crime);
		}
	}
}
