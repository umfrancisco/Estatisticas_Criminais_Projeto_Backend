package com.umfrancisco.estatisticas_criminais_project.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;

public class CsvFileParser {
	
	private static Long count = 1L;
	
	public static void read(Mapa mapa, String cidade, String fileName, Boolean porHabitante) throws IOException {
		Path path = Paths.get(fileName.formatted(cidade));
		List<String> lines = Files.readAllLines(path);
		for (var line : lines) {
			String[] fields = line.split(",");
			Integer ano = Integer.parseInt(fields[0]);
			Double homicidio = Double.parseDouble(fields[1]);
			Double furto = Double.parseDouble(fields[2]);
			Double roubo = Double.parseDouble(fields[3]);
			Double frv = Double.parseDouble(fields[4]);
			mapa.add(new Crime(count, cidade, ano, homicidio, furto, roubo, frv, porHabitante));
			count++;
		}
	}
}
