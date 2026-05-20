package com.umfrancisco.estatisticas_criminais_project.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;
import com.umfrancisco.estatisticas_criminais_project.service.CrimeService;

@RestController
@RequestMapping("/api/crimes")
public class CrimeController {

	private CrimeService service;
	
	public CrimeController(CrimeService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Crime> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/data")
	public void saveDataFromCsvFile() throws IOException {
		service.saveDataFromCsvFile();
	}
}
