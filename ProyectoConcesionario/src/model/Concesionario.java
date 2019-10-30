package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Concesionario {
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	private static HashMap<String, ArrayList<Vehiculo>> vehiculos = new HashMap<String, ArrayList<Vehiculo>>();
	private static List<Trabajador> trabajadores = new ArrayList<Trabajador>();
	
	//TODO m�todos para a�adir los elementos

	public static void iniciarClientes() {
		try {
			File f = new File("ficheros/clientes.csv");
			Scanner sc = new Scanner(f);
			
			System.out.println("Patata");

			while(sc.hasNextLine()) {
				String linea = sc.nextLine();

				//TODO castear la fecha desde aqu� o hacer simpledateFormat en cliente
				// Partimos la l�nea por ;
				Cliente c = new Cliente();
				String[] campos = linea.split(";");// recibe un argumento y devuleve un array de Strings 
				c.setLogin(campos[0]);
				c.setPassword(campos[1]);
				c.setEmail(campos[2]);
				c.setdNI(campos[3]);
				c.setNombre(campos[4]);
				c.setApellidos(campos[5]);
				c.setFechaNacimientoString((campos[6]));
				c.setNumTarjeta(Long.parseLong(campos[7]));
				
				
				clientes.add(c);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addVehiculo(Vehiculo vehiculo){
		//Crea para cada marca un arrayList de vehiculos (Honda tiene las dos)
		if(!vehiculos.containsKey(vehiculo.getMarca())) {
			vehiculos.put(vehiculo.getMarca(), new ArrayList<Vehiculo>());
		}
		vehiculos.get(vehiculo.getMarca()).add(vehiculo);
	}
}