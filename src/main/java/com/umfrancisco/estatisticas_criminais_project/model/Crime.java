package com.umfrancisco.estatisticas_criminais_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Crime {
	
	@Id
	private final Long id;
	@ManyToOne
	private final Cidade cidade;
	private final Integer ano;
	private final Integer homicidio;
	private final Integer furto;
	private final Integer roubo;
	private final Integer furtoRouboVeiculos;
	
	public Crime(Long id, Cidade cidade, Integer ano, Integer homicidio, Integer furto, Integer roubo,
			Integer furtoRouboVeiculos) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.ano = ano;
		this.homicidio = homicidio;
		this.furto = furto;
		this.roubo = roubo;
		this.furtoRouboVeiculos = furtoRouboVeiculos;
	}
	
	public Long getId() {
		return id;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public Integer getAno() {
		return ano;
	}
	public Integer getHomicidio() {
		return homicidio;
	}
	public Integer getFurto() {
		return furto;
	}
	public Integer getRoubo() {
		return roubo;
	}
	public Integer getFurtoRouboVeiculos() {
		return furtoRouboVeiculos;
	}
	
	@Override
	public String toString() {
		return "Crime [id=" + id + ", cidade=" + cidade + ", ano=" + ano + ", homicidio=" + homicidio + ", furto="
				+ furto + ", roubo=" + roubo + ", furtoRouboVeiculos=" + furtoRouboVeiculos + "]";
	}
}
