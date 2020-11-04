package com.ipn.escom.hugo.model;

import java.util.List;

public class AutomataN extends Automata {

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
					this.transiciones.add(new Transicion(inicio, fin, simbolo));
				}
			}
		}
	}

	public boolean esAFN() {
		return true;
	}

	public boolean esAFD() {
		return false;
	}

	public boolean acepta(String cadena) {
		return false;
	}
}
