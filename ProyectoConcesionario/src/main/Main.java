package main;

import java.util.Iterator;

import model.Concesionario;
import model.Trabajador;

import ventanas.VentanaCatalogoCoche;
import ventanas.VentanaInicial;

public class Main {

	public static void main(String[] args) {
		Concesionario c = new Concesionario();
		c.cargarTrabajadores();
		
		VentanaInicial.abirVentanaInicial(); //esto inicializa la ventana Inicial.
		
		//VentanaCatalogoCoche ventanaCatalogoCoche = new VentanaCatalogoCoche();
		//ventanaCatalogoCoche.setVisible(true);
		
		Iterator<Trabajador>it = c.getTrabajadores().iterator();
		
		while (it.hasNext()){
			Trabajador t = it.next();
			System.out.println(t.toString());
		}
	}
}
