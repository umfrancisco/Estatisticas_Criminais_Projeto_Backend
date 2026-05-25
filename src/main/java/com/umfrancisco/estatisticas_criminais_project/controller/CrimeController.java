package com.umfrancisco.estatisticas_criminais_project.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.estatisticas_criminais_project.model.CrimeDTO;
import com.umfrancisco.estatisticas_criminais_project.model.Infracao;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;
import com.umfrancisco.estatisticas_criminais_project.service.CrimeService;

@RestController
@RequestMapping("/api/crime")
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
	
	@GetMapping("/ano/{ano}/porhabitante/{porHabitante}")
	public List<Crime> findByAnoAndPorHabitante(@PathVariable Integer ano, @PathVariable Boolean porHabitante) {
		return service.findByAnoAndPorHabitante(ano, porHabitante);
	}
	
	@GetMapping("/{cidade}")
	public List<Crime> findByCidade(@PathVariable String cidade) {
		return service.findByCidade(cidade);
	}
	
	@GetMapping("/{cidade}/{infracao}/porhabitante/{porHabitante}")
	public List<CrimeDTO> findByCidadeAndInfracao(@PathVariable String cidade, @PathVariable String infracao, @PathVariable Boolean porHabitante) {
		infracao = infracao.toLowerCase();
		return switch (infracao) {
			case "homicidio" -> service.findByCidadeAndInfracao(cidade, Infracao.HOMICIDIO, porHabitante);
			case "furto" -> service.findByCidadeAndInfracao(cidade, Infracao.FURTO, porHabitante);
			case "roubo" -> service.findByCidadeAndInfracao(cidade, Infracao.ROUBO, porHabitante);
			case "veiculo" -> service.findByCidadeAndInfracao(cidade, Infracao.FURTO_ROUBO_VEICULO, porHabitante);
			default -> null;
		};
	}
	
	@GetMapping("/data")
	public String saveDataFromCsvFile() throws IOException {
		service.saveDataFromCsvFile();
		return "saved";
	}
}
