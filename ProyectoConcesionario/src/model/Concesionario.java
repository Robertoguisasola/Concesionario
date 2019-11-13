package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import dataBase.GestorBD;

public class Concesionario {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private HashMap<String, List<Vehiculo>> vehiculos = new HashMap<String, List<Vehiculo>>();
	private List<Trabajador> trabajadores = new ArrayList<Trabajador>();
	private List<Venta> ventas = new ArrayList<Venta>();
	
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
	
	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
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
	
	//TODO añadir vehículos
	
	/*public static void addVehiculo(Vehiculo vehiculo){
		//Crea para cada marca un arrayList de vehiculos (Honda tiene las dos)
		if(!vehiculos.containsKey(vehiculo.getMarca())) {
			vehiculos.put(vehiculo.getMarca(), new ArrayList<Vehiculo>());
		}
		vehiculos.get(vehiculo.getMarca()).add(vehiculo);
	}*/
}