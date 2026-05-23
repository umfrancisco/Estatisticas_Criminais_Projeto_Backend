package com.umfrancisco.estatisticas_criminais_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Crime {
	
	@Id
	private Long id;
	private String cidade;
	private Integer ano;
	private Double homicidio;
	private Double furto;
	private Double roubo;
	private Double furtoRouboVeiculos;
	private Boolean porHabitante;
	
	public Crime() {
		
	}
	
	public Crime(Long id, String cidade, Integer ano, Double homicidio, Double furto, Double roubo,
			Double furtoRouboVeiculos, Boolean porHabitante) {
		this.id = id;
		this.cidade = cidade;
		this.ano = ano;
		this.homicidio = homicidio;
		this.furto = furto;
		this.roubo = roubo;
		this.furtoRouboVeiculos = furtoRouboVeiculos;
		this.porHabitante = porHabitante;
	}
	
	public Long getId() {
		return id;
	}
	public String getCidade() {
		return cidade;
	}
	public Integer getAno() {
		return ano;
	}
	public Double getHomicidio() {
		return homicidio;
	}
	public Double getFurto() {
		return furto;
	}
	public Double getRoubo() {
		return roubo;
	}
	public Double getFurtoRouboVeiculos() {
		return furtoRouboVeiculos;
	}
	public Boolean getPorHabitante() {
		return porHabitante;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + ", cidade=" + cidade + ", ano=" + ano + ", homicidio=" + homicidio + ", furto="
				+ furto + ", roubo=" + roubo + ", furtoRouboVeiculos=" + furtoRouboVeiculos + ", porHabitante="
				+ porHabitante + "]";
	}
}
