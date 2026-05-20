package com.umfrancisco.estatisticas_criminais_project.model;

public class Cidade {
	
	private final String cidade;
	private final String estado;
	private final String fileName;
	
	public Cidade(String cidade, String estado, String fileName) {
		this.cidade = cidade;
		this.estado = estado;
		this.fileName = fileName;
	}
	
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getFileName() {
		return fileName;
	}
	
	@Override
	public String toString() {
		return "Cidade [cidade=" + cidade + ", estado=" + estado + ", fileName=" + fileName + "]";
	}
}
