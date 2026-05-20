package com.umfrancisco.estatisticas_criminais_project.model;

public class CrimeDTO {
	
	private String cidade;
	private Integer ano;
	private Infracao infracao;
	private Integer valor;
	
	public CrimeDTO() {
		
	}
	
	public CrimeDTO(String cidade, Integer ano, Infracao infracao, Integer valor) {
		this.cidade = cidade;
		this.ano = ano;
		this.infracao = infracao;
		this.valor = valor;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Infracao getInfracao() {
		return infracao;
	}
	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "CrimeDTO [cidade=" + cidade + ", ano=" + ano + ", infracao=" + infracao + ", valor=" + valor + "]";
	}
}
