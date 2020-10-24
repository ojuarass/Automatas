package com.ipn.escom.hugo.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ipn.escom.hugo.constant.Etiquetas;

public class LeerAutomata {

	private Scanner scanner;

	public List<String> leerArchivo(String archivo) {
		List<String> lineas = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(archivo);
			scanner = new Scanner(fis);
			while (scanner.hasNextLine()) {
				lineas.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lineas;
	}

	public int getInicial(String inicial) {
		String[] stringArray = inicial.split(":");
		if (stringArray[0].equalsIgnoreCase(Etiquetas.INICIAL)) {
			return Integer.parseInt(stringArray[1]);
		}
		return 0;
	}

	public List<Integer> getFinales(String finales) {
		List<Integer> listFinales = new ArrayList<>();
		String[] stringArray = finales.split(":");
		if (stringArray[0].equalsIgnoreCase(Etiquetas.FINALES)) {
			String[] splitFinales = stringArray[1].split(Etiquetas.DEL_COMUN);
			for (int i = 0; i < splitFinales.length; i++) {
				listFinales.add(Integer.parseInt(splitFinales[i]));
			}
		}
		return listFinales;
	}

	public Transicion getTransicion(String transicion) {
		String[] stringArray = transicion.split(Etiquetas.DEL_TRANSICION);
		String[] stringTr = stringArray[1].split(Etiquetas.DEL_COMUN);
		return new Transicion(Integer.parseInt(stringArray[0]), Integer.parseInt(stringTr[0]), stringTr[1].charAt(0));
	}

}
