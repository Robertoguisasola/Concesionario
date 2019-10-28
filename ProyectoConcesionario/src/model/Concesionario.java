package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Concesionario {
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	private static HashMap<String, ArrayList<Vehiculo>> vehiculos = new HashMap<String, ArrayList<Vehiculo>>();
	private static List<Trabajador> trabajadores = new ArrayList<Trabajador>();
	
	//TODO m�todos para a�adir los elementos
	
	public static void addVehiculo(Vehiculo vehiculo){
		//Crea para cada marca un arrayList de vehiculos (Honda tiene las dos)
		if(!vehiculos.containsKey(vehiculo.getMarca())) {
			vehiculos.put(vehiculo.getMarca(), new ArrayList<Vehiculo>());
		}
		vehiculos.get(vehiculo.getMarca()).add(vehiculo);
	}
}
