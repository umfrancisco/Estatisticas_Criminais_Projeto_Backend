package com.umfrancisco.estatisticas_criminais_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Crime {
	
	@Id
	private Long id;
	@ManyToOne
	private Cidade cidade;
	private Integer ano;
	private Integer homicidio;
	private Integer furto;
	private Integer roubo;
	private Integer furtoRouboVeiculos;
	
	public Crime() {
		
	}
	
	public Crime(Long id, Cidade cidade, Integer ano, Integer homicidio, Integer furto, Integer roubo,
			Integer furtoRouboVeiculos) {
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
