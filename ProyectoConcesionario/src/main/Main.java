package main;

import java.util.Iterator;

import model.Concesionario;
import model.Trabajador;
import ventanas.VentanaMenu;

public class Main {

	public static void main(String[] args) {
		Concesionario c = new Concesionario();
		c.cargarTrabajadores();
		
		VentanaMenu menu = new VentanaMenu();
		menu.setVisible(true);
		menu.setSize(450,260);
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
		
		Iterator<Trabajador>it = c.getTrabajadores().iterator();
		
		while (it.hasNext()){
			Trabajador t = it.next();
			System.out.println(t.toString());
		}
	}
}
