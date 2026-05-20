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
	
	public List<CrimeDTO> findByCidade(String cidade, Infracao infracao) {
		List<CrimeDTO> found = new ArrayList<>();
		List<Crime> list = findAll();
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
		
		Cidade campinas = new Cidade(random.nextLong(Long.MAX_VALUE), "Campinas", "SP", "campinas", "crime-stats-campinas.csv");
		Cidade ribeiraopreto = new Cidade(random.nextLong(Long.MAX_VALUE), "Ribeirão Preto", "SP", "ribeiraopreto", "crime-stats-ribeirao-preto.csv");
		Cidade saopaulo = new Cidade(random.nextLong(Long.MAX_VALUE), "São Paulo", "SP", "saopaulo", "crime-stats-sao-paulo.csv");
		cidadeService.save(campinas, ribeiraopreto, saopaulo);
		
		CsvFileParser.read(mapa, campinas);
		CsvFileParser.read(mapa, ribeiraopreto);
		CsvFileParser.read(mapa, saopaulo);
		
		for (var crime : mapa.getCrimes()) {
			save(crime);
		}
	}
}
