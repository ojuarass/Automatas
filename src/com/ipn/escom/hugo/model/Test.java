package com.ipn.escom.hugo.model;

//import java.util.List;

public class Test {

	public static void main(String[] args) {
//		LeerAutomata leer = new LeerAutomata();
		AutomataD determinista = new AutomataD();
		
		determinista.cargarDesde("C:\\Users\\tecmoi.jrodriguez\\automataDeterminista.af");
		
		String cadena = "ab";
		
		System.out.println(determinista.acepta(cadena));
		
		
		AutomataD noDeterminista = new AutomataD();
		
		noDeterminista.cargarDesde("C:\\Users\\tecmoi.jrodriguez\\automataDeterminista.af");
		
		String cadenaN = "ab";
		
		System.out.println(noDeterminista.acepta(cadenaN));

//		a.guardar("C:\\Users\\tecmoi.jrodriguez\\hugoautomata12.af");
		/*
inicial:1
finales:3
1->2,a
1->1,b
2->2,a
2->3,b
3->3,a
3->3,b
		 */

//		LeerAutomata reader = new LeerAutomata();
//		List<String> lineas = reader.leerArchivo("C:\\Users\\tecmoi.jrodriguez\\automata.af");
//		for (int i = 0; i < lineas.size(); i++) {
//			System.out.println(lineas.get(i));
//		}

	}

}
