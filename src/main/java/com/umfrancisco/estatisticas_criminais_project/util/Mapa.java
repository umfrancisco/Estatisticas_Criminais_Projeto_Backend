package com.umfrancisco.estatisticas_criminais_project.util;

import java.util.ArrayList;
import java.util.List;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;

public class Mapa {

	private List<Crime> crimes;
	
	public Mapa() {
		crimes = new ArrayList<Crime>();
	}
	
	public void add(Crime crime) {
		crimes.add(crime);
	}
	
	public List<Crime> getCrimes() {
		return crimes;
	}
}
