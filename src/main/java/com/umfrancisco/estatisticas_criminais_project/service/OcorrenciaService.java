package com.umfrancisco.estatisticas_criminais_project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.estatisticas_criminais_project.model.Ocorrencia;
import com.umfrancisco.estatisticas_criminais_project.model.CrimeDTO;
import com.umfrancisco.estatisticas_criminais_project.model.Data;
import com.umfrancisco.estatisticas_criminais_project.model.Infracao;
import com.umfrancisco.estatisticas_criminais_project.repository.OcorrenciaRepository;
import com.umfrancisco.estatisticas_criminais_project.util.CsvFileParser;
import com.umfrancisco.estatisticas_criminais_project.util.Mapa;

@Service
public class OcorrenciaService {
	
	private OcorrenciaRepository repository; 
	
	public OcorrenciaService(OcorrenciaRepository repository) {
		this.repository = repository;
	}
	
	public void save(Ocorrencia ocorrencia) {
		repository.save(ocorrencia);
	}
	
	public List<Ocorrencia> findAll() {
		return repository.findAll();
	}
	
	public List<Ocorrencia> findByCidade(String cidade) {
		List<Ocorrencia> list = findAll();
		List<Ocorrencia> found = new ArrayList<>();
		for (var c : list) {
			if (c.getCidade().equals(cidade)) {
				found.add(c);
			}
		}
		return found;
	}
	
	public List<CrimeDTO> findByCidadeAndInfracao(String cidade, Infracao infracao) {
		List<Ocorrencia> list = findAll();
		List<CrimeDTO> found = new ArrayList<>();
		for (var c : list) {
			if (c.getCidade().equals(cidade)) {
				String nomeCidade = c.getCidade();
				Integer ano = c.getAno();
				Integer valorInfracao = null;
				switch (infracao) {
					case HOMICIDIO -> valorInfracao = c.getHomicidio();
					case FURTO -> valorInfracao = c.getFurto();
					case ROUBO -> valorInfracao = c.getRoubo();
					case FURTO_ROUBO_VEICULO -> valorInfracao = c.getFurtoRouboVeiculos();
					default -> valorInfracao = null;
				}
				found.add(new CrimeDTO(nomeCidade, ano, infracao, Double.valueOf(valorInfracao)));
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
			CsvFileParser.read(mapa, cidade, Data.OCORRENCIA);			
		}
		for (var o : mapa.getOcorrencias()) {
			save(o);
		}
	}
}
