package com.umfrancisco.estatisticas_criminais_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cidade {
	
	@Id
	private Long id;
	private String cidade;
	private String estado;
	private String nomeCidadeUrl;
	
	public Cidade() {
		
	}
	
	public Cidade(Long id, String cidade, String estado, String nomeCidadeUrl) {
		this.id = id;
		this.cidade = cidade;
		this.estado = estado;
		this.nomeCidadeUrl = nomeCidadeUrl;
	}
	
	public Long getId() {
		return id;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getNomeCidadeUrl() {
		return nomeCidadeUrl;
	}
	
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", cidade=" + cidade + ", estado=" + estado + ", nomeCidadeUrl=" + nomeCidadeUrl+"]";
	}
}
