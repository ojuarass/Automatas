package com.ipn.escom.hugo.model;

import java.util.ArrayList;
import java.util.List;

public class AutomataD extends Automata {

	public void cargarDesde(String nombre) {
		LeerAutomata leer = new LeerAutomata();
		List<String> archivo = leer.leerArchivo(nombre);

		this.establecerInicial(leer.getInicial(archivo.get(0)));

		List<Integer> finales = leer.getFinales(archivo.get(1));
		for (int i = 0; i < finales.size(); i++) {
			this.establecerFinal(finales.get(i));
		}

		for (int i = 2; i < archivo.size(); i++) {
			Transicion tr = leer.getTransicion(archivo.get(i));
			this.agregarTransicion(tr.getInicio(), tr.getFin(), tr.getSimbolo());
		}
	}

	public void agregarTransicion(int inicio, int fin, char simbolo) {
		if (this.transiciones.isEmpty()) {
			this.transiciones.add(new Transicion(inicio, fin, simbolo));
		} else {
			int size = transiciones.size();
			for (int i = 0; i < size; i++) {
				Transicion tr = this.transiciones.get(i);
				if (tr.getInicio() == inicio && tr.getFin() == fin && tr.getSimbolo() == simbolo) {
					System.out.println("La transicion ya existe");
				} else {
					if (!existeSimbolo(transiciones, inicio, simbolo)) {
						this.transiciones.add(new Transicion(inicio, fin, simbolo));
					} else {
						System.out.println("El simbolo ya existe");
						break;
					}
					break;
				}
			}
		}
	}

	private boolean existeSimbolo(List<Transicion> transiciones, int inicial, char simbolo) {
		boolean bandera = false;
		for (int j = 0; j < transiciones.size(); j++) {
			Transicion trAux = transiciones.get(j);
			if (trAux.getInicio() == inicial && trAux.getSimbolo() == simbolo) {
				bandera = true;
			}
		}
		return bandera;
	}

	public boolean esAFN() {
		return true;
	}

	public boolean esAFD() {
		return false;
	}

	public boolean acepta(String cadena) {
		List<Transicion> trIniciales = new ArrayList<Transicion>();

		for (int i = 0; i < this.transiciones.size(); i++) {
			if (transiciones.get(i).getInicio() == this.trInicial) {
				trIniciales.add(transiciones.get(i));
			}
		}

		Integer estado = recorrerTransicion(trIniciales, cadena);

		return this.trFinales.contains(estado);
	}

	public Integer recorrerTransicion(List<Transicion> listaInicial, String cadena) {
		int size = listaInicial.size();
		Integer estado = listaInicial.get(0).getInicio();

		if (!cadena.isEmpty()) {
			for (int i = 0; i < size; i++) {
				Transicion tr = listaInicial.get(i);
				if (cadena.charAt(0) == tr.getSimbolo()) {
					listaInicial.clear();
					for (int j = 0; j < this.transiciones.size(); j++) {
						if (transiciones.get(j).getInicio() == tr.getFin()) {
							listaInicial.add(transiciones.get(j));
						}
					}
					
					return recorrerTransicion(listaInicial, cadena.substring(1, cadena.length()));
				}
			}
		}

		return estado;
	}
}
