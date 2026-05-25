package com.umfrancisco.estatisticas_criminais_project.model;

public record CrimeDTO(String cidade, Integer ano, Infracao infracao, Double valor) {
	
}
