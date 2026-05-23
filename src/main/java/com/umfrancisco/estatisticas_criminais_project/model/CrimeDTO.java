package com.umfrancisco.estatisticas_criminais_project.model;

public class CrimeDTO {
	
	private String cidade;
	private Integer ano;
	private Infracao infracao;
	private Double valor;
	
	public CrimeDTO() {
		
	}
	
	public CrimeDTO(String cidade, Integer ano, Infracao infracao, Double valor) {
		super();
		this.cidade = cidade;
		this.ano = ano;
		this.infracao = infracao;
		this.valor = valor;
	}
	
	public String getCidade() {
		return cidade;
	}
	public Integer getAno() {
		return ano;
	}
	public Infracao getInfracao() {
		return infracao;
	}
	public Double getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return "CrimeDTO [cidade=" + cidade + ", ano=" + ano + ", infracao=" + infracao + ", valor=" + valor + "]";
	}
}
