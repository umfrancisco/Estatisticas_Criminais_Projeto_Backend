package com.umfrancisco.estatisticas_criminais_project.util;

import java.util.ArrayList;
import java.util.List;

import com.umfrancisco.estatisticas_criminais_project.model.Ocorrencia;
import com.umfrancisco.estatisticas_criminais_project.model.TaxaDelito;

public class Mapa {

	private List<Ocorrencia> ocorrencias;
	private List<TaxaDelito> taxaDelitos;
	
	public Mapa() {
		ocorrencias = new ArrayList<Ocorrencia>();
		taxaDelitos = new ArrayList<TaxaDelito>();
	}
	
	public void add(Ocorrencia ocorrencia) {
		ocorrencias.add(ocorrencia);
	}
	
	public void add(TaxaDelito delito) {
		taxaDelitos.add(delito);
	}
	
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	
	public List<TaxaDelito> getTaxaDelitos() {
		return taxaDelitos;
	}
}
