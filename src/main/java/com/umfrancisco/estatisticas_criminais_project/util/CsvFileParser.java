package com.umfrancisco.estatisticas_criminais_project.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import com.umfrancisco.estatisticas_criminais_project.model.Ocorrencia;
import com.umfrancisco.estatisticas_criminais_project.model.TaxaDelito;

public class CsvFileParser {
	
	private static Random random = new Random();
	
	public static void read(Mapa mapa, String cidade, int option) throws IOException {
		if (option == 1) {
			readOcorrencia(mapa, cidade);
		}
		if (option == 2) {
			readTaxaDelito(mapa, cidade);
		}
	}
	
	public static void readOcorrencia(Mapa mapa, String cidade) throws IOException {
		Path path = Paths.get("data/ocorrencias-%s.csv".formatted(cidade));
		List<String> lines = Files.readAllLines(path);
		for (var line : lines) {
			String[] fields = line.split(",");
			Integer ano = Integer.parseInt(fields[0]);
			Integer homicidio = Integer.parseInt(fields[1]);
			Integer furto = Integer.parseInt(fields[2]);
			Integer roubo = Integer.parseInt(fields[3]);
			Integer frv = Integer.parseInt(fields[4]);
			mapa.add(new Ocorrencia(random.nextLong(Long.MAX_VALUE), cidade, ano, homicidio, furto, roubo, frv));
		}
	}
	
	public static void readTaxaDelito(Mapa mapa, String cidade) throws IOException {
		Path path = Paths.get("data/taxa-delito-%s.csv".formatted(cidade));
		List<String> lines = Files.readAllLines(path);
		for (var line : lines) {
			String[] fields = line.split(",");
			Integer ano = Integer.parseInt(fields[0]);
			Double homicidio = Double.parseDouble(fields[1]);
			Double furto = Double.parseDouble(fields[2]);
			Double roubo = Double.parseDouble(fields[3]);
			Double frv = Double.parseDouble(fields[4]);
			mapa.add(new TaxaDelito(random.nextLong(Long.MAX_VALUE), cidade, ano, homicidio, furto, roubo, frv));
		}
	}
}
