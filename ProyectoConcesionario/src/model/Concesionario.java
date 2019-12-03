package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Concesionario {
	//TODO como rellenar el hashmap de vehículos
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private HashMap<String, List<Vehiculo>> vehiculos = new HashMap<String, List<Vehiculo>>();
	private List<Trabajador> trabajadores = new ArrayList<Trabajador>();
	private Map<String, List<Venta>> ventas = new HashMap<String, List<Venta>>();
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public HashMap<String, List<Vehiculo>> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(HashMap<String, List<Vehiculo>> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}
		
	public Map<String, List<Venta>> getVentas() {
		return ventas;
	}

	public void setVentas(Map<String, List<Venta>> ventas) {
		this.ventas = ventas;
	}

	
	@Override
	public String toString() {
		return "Concesionario [clientes=" + clientes + ", vehiculos=" + vehiculos + ", trabajadores=" + trabajadores
				+ ", ventas=" + ventas + "]";
	}

	//TODO métodos para añadir los elementos a la bbd
	public void cargarClientes() {
		try {
			File f = new File("ficheros/clientes.csv");
			Scanner sc = new Scanner(f);

			while(sc.hasNextLine()) {
				String linea = sc.nextLine();

				//Cada campo está partido por ;
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
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cargarTrabajadores() {
		try {
			File f = new File("ficheros/trabajadores.csv");
			Scanner sc = new Scanner(f);

			while(sc.hasNextLine()) {
				String linea = sc.nextLine();

				//Cada campo está partido por ;
				Trabajador t = new Trabajador();
				
				String[] campos = linea.split(";");// recibe un argumento y devuleve un array de Strings 
				
				t.setLogin(campos[0]);
				t.setPassword(campos[1]);
				t.setEmail(campos[2]);
				t.setdNI(campos[3]);
				t.setNombre(campos[4]);
				t.setApellidos(campos[5]);
				t.setFechaNacimientoString((campos[6]));
				t.setSueldo(Integer.parseInt(campos[7]));
				
				trabajadores.add(t);	
			}
			
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//TODO añadir vehículos hay que hacer algo para que se pueda meeter en la clave la marva que es el campo 0 y todo slos demás campos en la lista del hasMap
	
	/*public static void addVehiculo(Vehiculo vehiculo){
		//Crea para cada marca un arrayList de vehiculos (Honda tiene las dos)
		if(!vehiculos.containsKey(vehiculo.getMarca())) {
			vehiculos.put(vehiculo.getMarca(), new ArrayList<Vehiculo>());
		}
		vehiculos.get(vehiculo.getMarca()).add(vehiculo);
	}*/
	
	
	public static void cargarVehiculo() {
		try {
			File f = new File("ficheros/coches.csv");
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				
			Coche c = new Coche();	
				
				String[] campos = linea.split(";");
				
				c.setMarca(campos[0]);
				c.setModelo(campos[1]);
				c.setColor(Colores.valueOf(campos[2])); //convierte el string en un enum
				c.setCaballos(Integer.parseInt(campos[3]));
				c.setNumRuedas(Integer.parseInt(campos[4]));
				c.setnPlazas(Integer.parseInt(campos[5]));
				c.setAutomatico(Boolean.parseBoolean(campos[6]));
				c.setLucesLed(Boolean.parseBoolean(campos[7]));
				c.setUrlFoto(campos[8]);
				c.setTechoPanoramico(Boolean.parseBoolean(campos[9]));
				c.setTraccion4x4(Boolean.parseBoolean(campos[10]));
				c.setModoDeportivo(Boolean.parseBoolean(campos[11]));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}