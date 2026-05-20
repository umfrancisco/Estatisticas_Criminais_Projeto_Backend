package com.umfrancisco.estatisticas_criminais_project.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;
import com.umfrancisco.estatisticas_criminais_project.model.CrimeDTO;
import com.umfrancisco.estatisticas_criminais_project.model.Infracao;
import com.umfrancisco.estatisticas_criminais_project.service.CrimeService;

@RestController
@RequestMapping("/api/crimes")
@CrossOrigin
public class CrimeController {

	private CrimeService service;
	
	public CrimeController(CrimeService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Crime> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{cidade}")
	public List<Crime> findByCidade(@PathVariable String cidade) {
		return service.findByCidade(cidade);
	}
	
	@GetMapping("/{cidade}/{infracao}")
	public List<CrimeDTO> findByCidadeAndInfracao(@PathVariable String cidade, @PathVariable String infracao) {
		infracao = infracao.toLowerCase();
		return switch (infracao) {
			case "homicidio" -> service.findByCidadeAndInfracao(cidade, Infracao.HOMICIDIO);
			case "furto" -> service.findByCidadeAndInfracao(cidade, Infracao.FURTO);
			case "roubo" -> service.findByCidadeAndInfracao(cidade, Infracao.ROUBO);
			case "veiculo" -> service.findByCidadeAndInfracao(cidade, Infracao.FURTO_ROUBO_VEICULO);
			default -> null;
		};
	}
	
	@GetMapping("/data")
	public String saveDataFromCsvFile() throws IOException {
		service.saveDataFromCsvFile();
		return "saved";
	}
}
