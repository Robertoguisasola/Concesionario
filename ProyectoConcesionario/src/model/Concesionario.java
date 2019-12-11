package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import dataBase.GestorBD;

public class Concesionario {
	//TODO como rellenar el hashmap de veh�culos
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private HashMap<String, List<Vehiculo>> vehiculos = new HashMap<String, List<Vehiculo>>();
	private List<Trabajador> trabajadores = new ArrayList<Trabajador>();
	private Map<String, List<Venta>> ventas = new HashMap<String, List<Venta>>();
	private static Logger logger = null;
	
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

	//TODO m�todos para a�adir los elementos a la bbdd
	public void cargarClientes() {
		try {
			File f = new File("ficheros/clientes.csv");
			Scanner sc = new Scanner(f);

			while(sc.hasNextLine()) {
				String linea = sc.nextLine();

				//Cada campo est� partido por ;
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

				//Cada campo est� partido por ;
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
			log(Level.SEVERE, "Error al cargar trabajadores desde el fichero", null);
		}
	}
	
	//TODO a�adir veh�culos hay que hacer algo para que se pueda meeter en la clave la marva que es el campo 0 y todo slos dem�s campos en la lista del hasMap
	
	/*public static void addVehiculo(Vehiculo vehiculo){
		//Crea para cada marca un arrayList de vehiculos (Honda tiene las dos)
		if(!vehiculos.containsKey(vehiculo.getMarca())) {
			vehiculos.put(vehiculo.getMarca(), new ArrayList<Vehiculo>());
		}
		vehiculos.get(vehiculo.getMarca()).add(vehiculo);
	}*/
	
	//TODO eliminar clase y pasar m�todos a la BBDD
	public static void cargarVehiculo() {
		try {
			File f = new File("ficheros/coches.csv");
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				
			Coche c = new Coche();	
				
				String[] campos = linea.split(";");
				
				//TODO modificar seg�n el fichero
				
				c.setMarca(campos[0]);
				c.setModelo(campos[1]);
				c.setColor(Colores.valueOf(campos[2])); //convierte el string en un enum
				c.setCaballos(Integer.parseInt(campos[3]));
				c.setNumRuedas(Integer.parseInt(campos[4]));
				c.setnPlazas(Integer.parseInt(campos[5]));
				sc.close();
			}
		} catch (Exception e) {
			log(Level.SEVERE, "Error al cargar veh�culos desde fichero", null);		}
	}
	
	public static void setLogger( Logger logger ) {
		Concesionario.logger = logger;
	}
	// M�todo local para loggear (si no se asigna un logger externo, se asigna uno local)
	private static void log(Level level, String msg, Throwable excepcion) {
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( GestorBD.class.getName() );  // Nombre del logger - el de la clase
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				// logger.addHandler( new FileHandler( "bd-" + System.currentTimeMillis() + ".log.xml" ) );  // Y saca el log a fichero xml
				logger.addHandler( new FileHandler("logger.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null) {
			logger.log(level, msg);
		}
		else {
			logger.log(level, msg, excepcion);
		}
	}
}