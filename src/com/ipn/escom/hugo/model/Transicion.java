package com.ipn.escom.hugo.model;

public class Transicion {
	private int inicio;
	private int fin;
	private char simbolo;
	
	public Transicion(int inicio, int fin, char simbolo) {
		this.inicio = inicio;
		this.fin = fin;
		this.simbolo = simbolo;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public String toString() {
		return "[inicio=" + inicio + ", fin=" + fin + ", simbolo=" + simbolo + "]";
	}
	
	

}
