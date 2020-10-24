package com.ipn.escom.hugo.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ipn.escom.hugo.constant.Etiquetas;

public abstract class Automata {
	protected List<Transicion> transiciones;
	protected Integer trInicial;
	protected List<Integer> trFinales;

	public Automata() {
		this.transiciones = new ArrayList<Transicion>();
		this.trFinales = new ArrayList<>();
	}

	public void guardar(String nombre) {
		StringBuilder sb = new StringBuilder();
		sb.append(Etiquetas.INICIAL).append(Etiquetas.DELIMITADOR).append(String.valueOf(trInicial)).append("\n");
		sb.append(Etiquetas.FINALES).append(Etiquetas.DELIMITADOR);
		for (int i = 0; i < trFinales.size(); i++) {
			sb.append(String.valueOf(trFinales.get(i)));
			if (i != trFinales.size() - 1) {
				sb.append(Etiquetas.DEL_COMUN);
			} else {
				sb.append("\n");
			}
		}

		for (int i = 0; i < transiciones.size(); i++) {
			Transicion tr = transiciones.get(i);
			sb.append(tr.getInicio()).append(Etiquetas.DEL_TRANSICION).append(tr.getFin()).append(Etiquetas.DEL_COMUN)
					.append(tr.getSimbolo()).append("\n");
		}

		FileWriter myWriter;
		try {
			myWriter = new FileWriter(nombre);
			myWriter.write(sb.toString());
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void establecerInicial(Integer estado) {
		this.trInicial = estado;
	}

	public void establecerFinal(Integer estado) {
		if (!this.trFinales.contains(estado)) {
			this.trFinales.add(estado);
		}
	}

	public Integer obtenerInicial() {
		return this.trInicial;
	}

	public List<Integer> obtenerFinales() {
		return this.trFinales;
	}

	public String generarCadena() {
		int letraInicial = 97; // 'a'
		int letraFinal = 122; // 'z'
		int longitud = 10;
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < longitud; i++) {
			int randomInt = letraInicial + (int) (random.nextFloat() * (letraFinal - letraInicial + 1));
			sb.append((char) randomInt);
		}
		return sb.toString();
	}

	public void eliminarTransicion(int inicio, int fin, char simbolo) {
		for (int i = 0; i < this.transiciones.size(); i++) {
			Transicion tr = this.transiciones.get(i);
			if (tr.getInicio() == inicio && tr.getFin() == fin && tr.getSimbolo() == simbolo) {
				transiciones.remove(i);
			}
		}
	}
}
