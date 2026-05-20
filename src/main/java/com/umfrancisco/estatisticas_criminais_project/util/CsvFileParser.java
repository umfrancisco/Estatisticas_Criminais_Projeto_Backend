package com.umfrancisco.estatisticas_criminais_project.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import com.umfrancisco.estatisticas_criminais_project.model.Cidade;
import com.umfrancisco.estatisticas_criminais_project.model.Crime;

public class CsvFileParser {
	
	private static Random random = new Random();
	
	public static void read(Mapa mapa, Cidade cidade) throws IOException {
		String fileName = cidade.getFileName();
		Path path = Paths.get(fileName);
		List<String> lines = Files.readAllLines(path);
		for (var line : lines) {
			String[] fields = line.split(",");
			Integer ano = Integer.parseInt(fields[0]);
			Integer homicidio = Integer.parseInt(fields[1]);
			Integer furto = Integer.parseInt(fields[2]);
			Integer roubo = Integer.parseInt(fields[3]);
			Integer frv = Integer.parseInt(fields[4]);
			mapa.add(new Crime(random.nextLong(Long.MAX_VALUE), cidade, ano, homicidio, furto, roubo, frv));
		}
	}
	
}
