package main;

import model.Concesionario;
import ventanas.ventanaMenu;

public class Main {

	public static void main(String[] args) {
		Concesionario c = new Concesionario();
		
		ventanaMenu menu = new ventanaMenu();
		menu.setVisible(true);
		menu.setSize(450,260);
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
		
		System.out.println(c);

	}

}
