package dataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Coche;
import model.Coche2;
import model.Moto;
import model.Moto2;
import model.Trabajador;
import model.Venta2;
import model.VentaCoche;
import model.VentaMoto;

public class GestorBD {
	//TODO optimizar clase
	private static Exception lastError = null; //Último error que ha sucedido
	private Connection conn;
	private static Logger logger = null;

	public GestorBD() {
		conectar();
	}

	private void conectar(){
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:ficheros/baseDeDatos.db");
			log(Level.INFO, "Conectado a la base de datos", null);
		} catch (ClassNotFoundException | SQLException e) {
			setLastError(e);
			log(Level.SEVERE, "Error en conexión de base de datos ", e);
			e.printStackTrace();
		}
	}

	public void desconectar(){
		try {
			conn.close();
			log(Level.INFO, "Desconectado de la base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al desconectar la base de datos", e);
			e.printStackTrace();
		}
	}

	private void borrar(String tabla) {
		String sqlBorrar= "DELETE FROM " + tabla;

		Statement stmtBorrar;

		try {
			stmtBorrar = conn.createStatement();

			stmtBorrar.executeUpdate(sqlBorrar);

			log(Level.INFO, "Borrado de la tabla " + tabla + " de la base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al borrar la tabla " + tabla + " de la base de datos", e);
			e.printStackTrace();
		}
	}

	public void importarFicheroABBDD(String tabla){
		borrar(tabla);

		switch (tabla) {
		case "trabajador":
			importarTrabajadores();
			break;
		case "cliente":
			importarClientes();
			break;
		case "coche":
			importarCoches();
			break;
		case "coche2":
			importarCoches2();
			break;
		case "moto":
			importarMotos();
			break;
		case "moto2":
			importarMotos2();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Pongase en contacto con el desarrollador para importar este fichero");
			break;
		}
	}

	public void exportarBBDDAFichero(String tabla) {
		//TODO exportar ventas de coches, coches de 2ª mano, motos y motos de 2ª mano

		switch (tabla) {
		case "trabajador":
			exportarTrabajadores();
			break;
		case "cliente":
			exportarClientes();
			break;
		case "coche":
			exportarCoches();
			break;
		case "coche2":
			exportarCoches2();
			break;
		case "moto":
			exportarMotos();
			break;
		case "moto2":
			exportarMotos2();
			break;
		case "ventacoche":
			exportarVentasCoches();
			break;
		case "ventacoche2":
			//TODO aaaa TERMINAR
			//exportarVentasCoches2();
			break;
		case "ventamoto":
			//exportarVentasMotos();
			break;
		case "ventamoto2":
			//exportarVentasMotos2();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Pongase en contacto con el desarrollador para importar este fichero");
			break;
		}
	}

	private void importarTrabajadores(){
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();

		File f = null;
		Scanner sc = null;

		try {
			f = new File("ficheros/trabajadores.csv");
			sc = new Scanner(f);

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
				t.setAdmin(Boolean.parseBoolean(campos[8]));

				trabajadores.add(t);
			}
			sc.close();

			log(Level.INFO, "Trabajadores cargados desde el fichero", null);
		} catch (Exception e) {
			log(Level.SEVERE, "Error al cargar trabajadores desde el fichero", null);
		}

		Iterator<Trabajador>it = trabajadores.iterator();


		while (it.hasNext()){			
			Trabajador t  = it.next();

			anadirNuevoTrabajador(t);
		}
		log(Level.INFO, "Trabajadores añadidos a la base de datos", null);
	}

	private void importarClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();

		File f = null;
		Scanner sc = null;

		try {
			f = new File("ficheros/clientes.csv");
			sc = new Scanner(f);

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

			log(Level.INFO, "Clientes cargados desde el fichero", null);
		} catch (Exception e) {
			e.printStackTrace();
			log(Level.SEVERE, "Error al cargar los clientes desde el fichero", null);
		} finally {
			sc.close();
		}

		Iterator<Cliente>it = clientes.iterator();

		while (it.hasNext()){			
			Cliente c  = it.next();

			anadirNuevoCliente(c);
		}
		log(Level.INFO, "Clientes añadidos a la base de datos", null);
	}

	private void importarCoches(){
		List<Coche> coches = new ArrayList<Coche>();

		File f = null;
		Scanner sc = null;

		try {
			f = new File("ficheros/coches.csv");
			sc = new Scanner(f);

			while(sc.hasNextLine()) {
				String linea = sc.nextLine();

				//Cada campo está partido por ;
				Coche c = new Coche();

				String[] campos = linea.split(";");// recibe un argumento y devuleve un array de Strings

				c.setMarca(campos[0].toLowerCase());
				c.setModelo(campos[1].toLowerCase());
				c.setColorString(campos[2].toLowerCase());
				c.setCaballos(Integer.parseInt(campos[3]));
				c.setNumRuedas(Integer.parseInt(campos[4]));
				c.setnPlazas(Integer.parseInt(campos[5]));
				c.setPrecio(Integer.parseInt(campos[6]));
				c.setMotorDiesel(Boolean.parseBoolean(campos[7]));

				coches.add(c);
			}
			log(Level.INFO, "Coches cargados desde el fichero", null);
		} catch (Exception e) {
			e.printStackTrace();
			log(Level.SEVERE, "Error al cargar los coches desde el fichero", null);
		} finally {
			sc.close();
		}

		Iterator<Coche>it = coches.iterator();

		while (it.hasNext()){			
			Coche c  = it.next();

			anadirNuevoCoche(c);
		}
		log(Level.INFO, "Coches añadidos a la base de datos", null);
	}

	private void importarCoches2(){
		List<Coche2> coches = new ArrayList<Coche2>();

		File f = null;
		Scanner sc = null;

		try {
			f = new File("ficheros/coches2.csv");
			sc = new Scanner(f);

			while(sc.hasNextLine()) {
				String linea = sc.nextLine();

				//Cada campo está partido por ;
				Coche2 c = new Coche2();

				String[] campos = linea.split(";");// recibe un argumento y devuleve un array de Strings

				c.setMarca(campos[0].toLowerCase());
				c.setModelo(campos[1].toLowerCase());
				c.setColorString(campos[2].toLowerCase());
				c.setCaballos(Integer.parseInt(campos[3]));
				c.setNumRuedas(Integer.parseInt(campos[4]));
				c.setnPlazas(Integer.parseInt(campos[5]));
				c.setPrecio(Integer.parseInt(campos[6]));
				c.setMotorDiesel(Boolean.parseBoolean(campos[7]));
				c.numKilometros(Integer.parseInt(campos[8]));

				coches.add(c);
			}
			log(Level.INFO, "Coches de segunda mano cargados desde el fichero", null);
		} catch (Exception e) {
			e.printStackTrace();
			log(Level.SEVERE, "Error al cargar los coches de segunda mano desde el fichero", null);
		} finally {
			sc.close();
		}

		Iterator<Coche2>it = coches.iterator();

		while (it.hasNext()){			
			Coche2 c  = it.next();

			anadirNuevoCoche2(c);
		}
		log(Level.INFO, "Coches de segunda mano añadidos a la base de datos", null);
	}
	private void importarMotos(){
		List<Moto> motos = new ArrayList<Moto>();

		File f = null;
		Scanner sc = null;

		try {
			f = new File("ficheros/motos.csv");
			sc = new Scanner(f);

			while(sc.hasNextLine()) {
				String linea = sc.nextLine();

				//Cada campo está partido por ;
				Moto m = new Moto();

				String[] campos = linea.split(";");// recibe un argumento y devuleve un array de Strings

				m.setMarca(campos[0].toLowerCase());
				m.setModelo(campos[1].toLowerCase());
				m.setColorString(campos[2].toLowerCase());
				m.setCaballos(Integer.parseInt(campos[3]));
				m.setNumRuedas(Integer.parseInt(campos[4]));
				m.setnPlazas(Integer.parseInt(campos[5]));
				m.setPrecio(Integer.parseInt(campos[6]));
				m.setEstructuraProtectora(Boolean.parseBoolean(campos[7]));

				motos.add(m);
			}
			log(Level.INFO, "Motos cargadas desde el fichero", null);
		} catch (Exception e) {
			e.printStackTrace();
			log(Level.SEVERE, "Error al cargar las motos desde el fichero", null);
		} finally {
			sc.close();
		}

		Iterator<Moto>it = motos.iterator();

		while (it.hasNext()){			
			Moto m  = it.next();

			anadirNuevaMoto(m);
		}
		log(Level.INFO, "Motos añadidas a la base de datos", null);
	}

	private void importarMotos2(){
		List<Moto2> motos = new ArrayList<Moto2>();

		File f = null;
		Scanner sc = null;

		try {
			f = new File("ficheros/motos2.csv");
			sc = new Scanner(f);

			while(sc.hasNextLine()) {
				String linea = sc.nextLine();

				//Cada campo está partido por ;
				Moto2 m = new Moto2();

				String[] campos = linea.split(";");// recibe un argumento y devuleve un array de Strings

				m.setMarca(campos[0].toLowerCase());
				m.setModelo(campos[1].toLowerCase());
				m.setColorString(campos[2].toLowerCase());
				m.setCaballos(Integer.parseInt(campos[3]));
				m.setNumRuedas(Integer.parseInt(campos[4]));
				m.setnPlazas(Integer.parseInt(campos[5]));
				m.setPrecio(Integer.parseInt(campos[6]));
				m.setEstructuraProtectora(Boolean.parseBoolean(campos[7]));
				m.numKilometros(Integer.parseInt(campos[8]));

				motos.add(m);
			}
			log(Level.INFO, "Motos de segunda mano cargadas desde el fichero", null);
		} catch (Exception e) {
			e.printStackTrace();
			log(Level.SEVERE, "Error al cargar las motos de segunda mano desde el fichero", null);
		} finally {
			sc.close();
		}

		Iterator<Moto2>it = motos.iterator();

		while (it.hasNext()){			
			Moto2 m = it.next();

			anadirNuevaMoto2(m);
		}
		log(Level.INFO, "Motos de segunda mano añadidas a la base de datos", null);
	}
	private void exportarTrabajadores(){
		//TODO ffff modificar el fichero si funciona bien, para ver si conseguimos que se sobreescriban
		FileWriter f = null;
		List<Trabajador>trabajadores = obtenerTrabajadores();

		try {
			f = new FileWriter("ficheros/trabajadoresExp.csv");

			for (Trabajador t : trabajadores) {
				String login = t.getLogin();
				String password = t.getPassword();
				String email = t.getEmail();
				String dNI = t.getdNI();
				String nombre = t.getNombre();
				String apellidos = t.getApellidos();
				String fechaNacimiento = t.getFechaNacimientoString();
				int sueldo = t.getSueldo();
				boolean admin = t.isAdmin();

				f.write(login + ";" + password + ";" + email + ";" + dNI + ";" + nombre + ";" + apellidos + ";" + fechaNacimiento + ";" + sueldo + ";" + admin + "\n");

				log(Level.INFO, "El trabajador " + t.toString() + " ha sido exportado correctamente", null);
			}

			log(Level.INFO, "Trabajadores exportados", null);
		} catch (IOException e) {
			log(Level.SEVERE, "Error al abrir el fichero para exportar trabajadores", e);
			e.printStackTrace();
		} finally {
			try {
				if(f != null) {
					f.close();
				}
			} catch (IOException e) {
				log(Level.SEVERE, "Error al cerrar el fichero de exportar trabajadores", e);
				e.printStackTrace();
			}
		}
	}

	private void exportarClientes() {
		//TODO ffff modificar el fichero si funciona bien, para ver si conseguimos que se sobreescriban
		FileWriter f = null;
		List<Cliente>clientes = obtenerClientes();

		try {
			f = new FileWriter("ficheros/clientesExp.csv");

			for (Cliente c : clientes) {
				String login = c.getLogin();
				String password = c.getPassword();
				String email = c.getEmail();
				String dNI = c.getdNI();
				String nombre = c.getNombre();
				String apellidos = c.getApellidos();
				String fechaNacimiento = c.getFechaNacimientoString();
				long numTarjeta = c.getNumTarjeta();

				f.write(login + ";" + password + ";" + email + ";" + dNI + ";" + nombre + ";" + apellidos + ";" + fechaNacimiento + ";" + numTarjeta + "\n");

				log(Level.INFO, "El cliente " + c.toString() + " ha sido exportado correctamente", null);
			}

			log(Level.INFO, "Clientes exportados", null);
		} catch (IOException e) {
			log(Level.SEVERE, "Error al abrir el fichero para exportar clientes", e);
			e.printStackTrace();
		} finally {
			try {
				if(f != null) {
					f.close();
				}
			} catch (IOException e) {
				log(Level.SEVERE, "Error al cerrar el fichero de exportar clientes", e);
				e.printStackTrace();
			}
		}
	}

	private void exportarCoches(){
		//TODO ffff modificar el fichero si funciona bien, para ver si conseguimos que se sobreescriban
		FileWriter f = null;
		List<Coche> coches = obtenerCoches();

		try {
			f = new FileWriter("ficheros/cochesExp.csv");

			for (Coche c : coches) {
				String marca = c.getMarca();
				String modelo = c.getModelo();
				String color = c.getColorString();
				int caballos = c.getCaballos();
				int numRuedas = c.getNumRuedas();
				int nPlazas = c.getnPlazas();
				int precio = c.getPrecio();
				boolean motorDiesel = c.isMotorDiesel();

				f.write(marca + ";" + modelo + ";" + color + ";" + caballos + ";" + numRuedas + ";" + nPlazas + ";" + precio + ";" + motorDiesel + "\n");

				log(Level.INFO, "El coche " + c.toString() + " ha sido exportado correctamente", null);
			}

			log(Level.INFO, "Coches exportados correctamente", null);
		} catch (IOException e) {
			log(Level.SEVERE, "Error al abrir el fichero para exportar coches", e);
			e.printStackTrace();
		} finally {
			try {
				if(f != null) {
					f.close();
				}
			} catch (IOException e) {
				log(Level.SEVERE, "Error al cerrar el fichero de exportar coches", e);
				e.printStackTrace();
			}
		}
	}

	private void exportarCoches2(){
		//TODO ffff modificar el fichero si funciona bien, para ver si conseguimos que se sobreescriban
		FileWriter f = null;
		List<Coche2> coches = obtenerCoches2();

		try {
			f = new FileWriter("ficheros/coches2Exp.csv");

			for (Coche2 c : coches) {
				String marca = c.getMarca();
				String modelo = c.getModelo();
				String color = c.getColorString();
				int caballos = c.getCaballos();
				int numRuedas = c.getNumRuedas();
				int nPlazas = c.getnPlazas();
				int precio = c.getPrecio();
				boolean motorDiesel = c.isMotorDiesel();
				int kilometros = c.getKilometros();

				f.write(marca + ";" + modelo + ";" + color + ";" + caballos + ";" + numRuedas + ";" + nPlazas + ";" + precio + ";" + motorDiesel + ";" + kilometros + "\n");

				log(Level.INFO, "El coche de segunda mano " + c.toString() + " ha sido exportado correctamente", null);
			}

			log(Level.INFO, "Coches de segunda mano exportados", null);
		} catch (IOException e) {
			log(Level.SEVERE, "Error al abrir el fichero para exportar coches de segunda mano", e);
			e.printStackTrace();
		} finally {
			try {
				if(f != null) {
					f.close();
				}
			} catch (IOException e) {
				log(Level.SEVERE, "Error al cerrar el fichero de exportar coches de segunda mano", e);
				e.printStackTrace();
			}
		}
	}

	private void exportarMotos(){
		//TODO ffff modificar el fichero si funciona bien, para ver si conseguimos que se sobreescriban
		FileWriter f = null;
		List<Moto> motos = obtenerMotos();

		try {
			f = new FileWriter("ficheros/motosExp.csv");

			for (Moto m : motos) {
				String marca = m.getMarca();
				String modelo = m.getModelo();
				String color = m.getColorString();
				int caballos = m.getCaballos();
				int numRuedas = m.getNumRuedas();
				int nPlazas = m.getnPlazas();
				int precio = m.getPrecio();
				boolean estructuraProtectora = m.isEstructuraProtectora();

				f.write(marca + ";" + modelo + ";" + color + ";" + caballos + ";" + numRuedas + ";" + nPlazas + ";" + precio + ";" + estructuraProtectora + "\n");

				log(Level.INFO, "La moto " + m.toString() + " ha sido exportado correctamente", null);
			}

			log(Level.INFO, "Motos exportadas correctamente", null);
		} catch (IOException e) {
			log(Level.SEVERE, "Error al abrir el fichero para exportar coches", e);
			e.printStackTrace();
		} finally {
			try {
				if(f != null) {
					f.close();
				}
			} catch (IOException e) {
				log(Level.SEVERE, "Error al cerrar el fichero de exportar coches", e);
				e.printStackTrace();
			}
		}
	}

	private void exportarMotos2(){
		//TODO ffff modificar el fichero si funciona bien, para ver si conseguimos que se sobreescriban
		FileWriter f = null;
		List<Moto2> motos = obtenerMotos2();

		try {
			f = new FileWriter("ficheros/motos2Exp.csv");

			for (Moto2 m : motos) {
				String marca = m.getMarca();
				String modelo = m.getModelo();
				String color = m.getColorString();
				int caballos = m.getCaballos();
				int numRuedas = m.getNumRuedas();
				int nPlazas = m.getnPlazas();
				int precio = m.getPrecio();
				boolean estructuraProtectora = m.isEstructuraProtectora();
				int kilometros = m.getKilometros();

				f.write(marca + ";" + modelo + ";" + color + ";" + caballos + ";" + numRuedas + ";" + nPlazas + ";" + precio + ";" + estructuraProtectora + ";" + kilometros + "\n");

				log(Level.INFO, "La moto " + m.toString() + " ha sido exportado correctamente", null);
			}

			log(Level.INFO, "Motos de segunda mano exportados correctamente", null);
		} catch (IOException e) {
			log(Level.SEVERE, "Error al abrir el fichero para exportar motos de segunda mano", e);
			e.printStackTrace();
		} finally {
			try {
				if(f != null) {
					f.close();
				}
			} catch (IOException e) {
				log(Level.SEVERE, "Error al cerrar el fichero de exportar motos de segunda mano", e);
				e.printStackTrace();
			}
		}
	}

	private void exportarVentasCoches(){
		FileWriter f = null;

		String sql = "SELECT dNI, coche, precio, matricula, isAutomatico, isLucesLed, isTechoPanoramico, isTraccion4x4, isModoDeportivo FROM ventacoche";
		PreparedStatement stmt;

		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo las ventas de los coches", null);

			f = new FileWriter("ficheros/ventasCochesExp.csv");

			for (int i = 0;i<9;i++) {
				if (i == 4) {
					if (rs.getObject(i+1).equals(0)) {
						f.write("NO;");
					} else {
						f.write("SI;");
					}
				} else if (i == 5) {
					if (rs.getObject(i+1).equals(0)) {
						f.write("NO;");
					} else {
						f.write("SI;");
					}
				} else if (i == 6) {
					if (rs.getObject(i+1).equals(0)) {
						f.write("NO;");
					} else {
						f.write("SI;");
					}
				} else if (i == 7) {
					if (rs.getObject(i+1).equals(0)) {
						f.write("NO;");
					} else {
						f.write("SI;");
					}
				} else if (i == 8) {
					if (rs.getObject(i+1).equals(0)) {
						f.write("NO;");
					} else {
						f.write("SI;");
					}
				} else {
					f.write(rs.getObject(i+1) + ";");
				}
			}

		} catch (IOException e2) {
			log(Level.SEVERE, "Error al escribir en el fichero de exportar ventas de coches", e2);
			e2.printStackTrace();
		} catch (SQLException e1) {
			log(Level.SEVERE, "Error al obtener las ventas de los coches de la base de datos", e1);
			e1.printStackTrace();
		} catch (Exception e) {
			log(Level.SEVERE, "Error al exportar las ventas de los coches", e);
			e.printStackTrace();
		}finally {
			try {
				if(f != null) {
					f.close();
				}
			} catch (IOException e) {
				log(Level.SEVERE, "Error al cerrar el fichero de exportar ventas de coches", e);
				e.printStackTrace();
			}
		}
	}

	public List<Trabajador> obtenerTrabajadores(){
		String sql = "SELECT login, password, email, dNI, nombre, apellidos, fechaNacimiento, sueldo, isAdmin FROM trabajador";
		PreparedStatement stmt;

		List<Trabajador> trabajadores = new ArrayList<Trabajador>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Trabajador t = new Trabajador();
				t.setLogin(rs.getString("login"));
				t.setPassword(rs.getString("password"));
				t.setEmail(rs.getString("email"));
				t.setdNI(rs.getString("dNI"));
				t.setNombre(rs.getString("nombre"));
				t.setApellidos(rs.getString("apellidos"));
				try {
					t.setFechaNacimientoString(rs.getString("fechaNacimiento"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				t.setSueldo(rs.getInt("sueldo"));

				if (rs.getInt("isAdmin") == 0) {
					t.setAdmin(false);
				} else {
					t.setAdmin(true);
				}

				trabajadores.add(t);
			}
			log(Level.INFO, "Obteniendo los trabajadores", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los trabajadores", e);
			e.printStackTrace();
		}
		return trabajadores;
	}

	public List<Cliente> obtenerClientes(){
		String sql = "SELECT login, password, email, dNI, nombre, apellidos, fechaNacimiento, numTarjeta FROM cliente";
		PreparedStatement stmt;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Cliente c = new Cliente();
				c.setLogin(rs.getString("login"));
				c.setPassword(rs.getString("password"));
				c.setEmail(rs.getString("email"));
				c.setdNI(rs.getString("dNI"));
				c.setNombre(rs.getString("nombre"));
				c.setApellidos(rs.getString("apellidos"));
				try {
					c.setFechaNacimientoString(rs.getString("fechaNacimiento"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c.setNumTarjeta(rs.getLong("numTarjeta"));

				clientes.add(c);
			}

			log(Level.INFO, "Obteniendo los clientes", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los clientes", e);
			e.printStackTrace();
		}
		return clientes;
	}

	public List<Coche> obtenerCoches(){
		String sql = "SELECT marca, modelo, color, caballos, numRuedas, nPlazas, precio, motorDiesel FROM coche";
		PreparedStatement stmt;

		List<Coche> coches = new ArrayList<Coche>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Coche c = new Coche();
				c.setMarca(rs.getString("marca"));
				c.setModelo(rs.getString("modelo"));
				c.setColorString(rs.getString("color"));
				c.setCaballos(rs.getInt("caballos"));
				c.setNumRuedas(rs.getInt("numRuedas"));
				c.setnPlazas(rs.getInt("nPlazas"));
				c.setPrecio(rs.getInt("precio"));

				if (rs.getInt("motorDiesel") == 0) {
					c.setMotorDiesel(false);
				} else {
					c.setMotorDiesel(true);
				}

				coches.add(c);
			}

			log(Level.INFO, "Obteniendo los coches", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los coches", e);
			e.printStackTrace();
		}
		return coches;
	}

	public List<Coche2> obtenerCoches2(){
		String sql = "SELECT marca, modelo, color, caballos, numRuedas, nPlazas, precio, motorDiesel, kilometros FROM coche2";
		PreparedStatement stmt;

		List<Coche2> coches = new ArrayList<Coche2>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Coche2 c = new Coche2();
				c.setMarca(rs.getString("marca"));
				c.setModelo(rs.getString("modelo"));
				c.setColorString(rs.getString("color"));
				c.setCaballos(rs.getInt("caballos"));
				c.setNumRuedas(rs.getInt("numRuedas"));
				c.setnPlazas(rs.getInt("nPlazas"));
				c.setPrecio(rs.getInt("precio"));

				if (rs.getInt("motorDiesel") == 0) {
					c.setMotorDiesel(false);
				} else {
					c.setMotorDiesel(true);
				}

				c.numKilometros(rs.getInt("kilometros"));

				coches.add(c);
			}

			log(Level.INFO, "Obteniendo los coches de segunda mano", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los coches de segunda manoS", e);
			e.printStackTrace();
		}
		return coches;
	}

	public List<Moto> obtenerMotos(){
		String sql = "SELECT marca, modelo, color, caballos, numRuedas, nPlazas, precio, estructuraProtectora FROM moto";
		PreparedStatement stmt;

		List<Moto> motos = new ArrayList<Moto>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Moto m = new Moto();
				m.setMarca(rs.getString("marca"));
				m.setModelo(rs.getString("modelo"));
				m.setColorString(rs.getString("color"));
				m.setCaballos(rs.getInt("caballos"));
				m.setNumRuedas(rs.getInt("numRuedas"));
				m.setnPlazas(rs.getInt("nPlazas"));
				m.setPrecio(rs.getInt("precio"));

				if (rs.getInt("estructuraProtectora") == 0) {
					m.setEstructuraProtectora(false);
				} else {
					m.setEstructuraProtectora(true);
				}

				motos.add(m);
			}

			log(Level.INFO, "Obteniendo las motos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener las motos", e);
			e.printStackTrace();
		}
		return motos;
	}

	public List<Moto2> obtenerMotos2(){
		String sql = "SELECT marca, modelo, color, caballos, numRuedas, nPlazas, precio, estructuraProtectora, kilometros FROM moto2";
		PreparedStatement stmt;

		List<Moto2> motos = new ArrayList<Moto2>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Moto2 m = new Moto2();
				m.setMarca(rs.getString("marca"));
				m.setModelo(rs.getString("modelo"));
				m.setColorString(rs.getString("color"));
				m.setCaballos(rs.getInt("caballos"));
				m.setNumRuedas(rs.getInt("numRuedas"));
				m.setnPlazas(rs.getInt("nPlazas"));
				m.setPrecio(rs.getInt("precio"));

				if (rs.getInt("estructuraProtectora") == 0) {
					m.setEstructuraProtectora(false);
				} else {
					m.setEstructuraProtectora(true);
				}

				m.numKilometros(rs.getInt("kilometros"));

				motos.add(m);
			}

			log(Level.INFO, "Obteniendo las motos de segunda mano", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener las motos de segunda mano", e);
			e.printStackTrace();
		}
		return motos;
	}

	public Cliente iniciarSesionCliente(String usuario, String contra){
		List<Cliente> clientes = obtenerClientes();

		Iterator<Cliente> itClientes = clientes.iterator();

		while (itClientes.hasNext()) {
			Cliente c = itClientes.next();

			String login = c.getLogin();
			String password = c.getPassword();

			if (login.equals(usuario)) {
				if (password.equals(contra)) {
					return c;
				}
			}	
		}
		return null;
	}

	public Trabajador iniciarSesionTrabajador(String usuario, String contra){
		List<Trabajador> trabajadores = obtenerTrabajadores();

		Iterator<Trabajador> itTrabajadores = trabajadores.iterator();

		while (itTrabajadores.hasNext()) {
			Trabajador t = itTrabajadores.next();

			String login = t.getLogin();
			String password = t.getPassword();

			if (login.equals(usuario)) {
				if (password.equals(contra)) {
					return t;
				}
			}	
		}
		return null;
	}

	public void anadirNuevoCliente(Cliente c){
		String sql  = "INSERT INTO cliente (login, password, email, dNI, nombre, apellidos, fechaNacimiento, numTarjeta)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, c.getLogin());
			stmt.setString(2, c.getPassword());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getdNI());
			stmt.setString(5, c.getNombre());
			stmt.setString(6, c.getApellidos());
			stmt.setString(7, c.getFechaNacimientoString());
			stmt.setLong(8, c.getNumTarjeta());

			stmt.executeUpdate();

			log(Level.INFO, "El cliente " + c.getNombre() + " ha sido añadido", null);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error al insertar el cliente" + sql, e );
			setLastError(e);
			e.printStackTrace();
		}
	}

	public void anadirNuevoTrabajador(Trabajador t) {
		String sql  = "INSERT INTO trabajador (login, password, email, dNI, nombre, apellidos, fechaNacimiento, sueldo, isAdmin)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, t.getLogin());
			stmt.setString(2, t.getPassword());
			stmt.setString(3, t.getEmail());
			stmt.setString(4, t.getdNI());
			stmt.setString(5, t.getNombre());
			stmt.setString(6, t.getApellidos());
			stmt.setString(7, t.getFechaNacimientoString());
			stmt.setInt(8, t.getSueldo());

			if (t.isAdmin()) {
				stmt.setInt(9, 1);
			} else {
				stmt.setInt(9, 0);
			}

			stmt.executeUpdate();

			log(Level.INFO, "El trabajador " + t.getNombre() + " ha sido añadido", null);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error al insertar el trabajador" + sql, e );
			setLastError(e);
			e.printStackTrace();
		}
	}

	public void anadirNuevoCoche(Coche c) {
		String sql  = "INSERT INTO coche (marca, modelo, color, caballos, numRuedas, nPlazas, precio, motorDiesel)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;

		try {			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, c.getMarca());
			stmt.setString(2, c.getModelo());
			stmt.setString(3, c.getColorString());
			stmt.setInt(4, c.getCaballos());
			stmt.setInt(5, c.getNumRuedas());
			stmt.setInt(6, c.getnPlazas());
			stmt.setInt(7, c.getPrecio());

			if (c.isMotorDiesel()) {
				stmt.setInt(8, 1);
			}else {
				stmt.setInt(8, 0);
			}

			stmt.executeUpdate();

			log(Level.INFO, "El coche " + c.toString() + " ha sido añadido", null);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error al insertar el coche " + c.toString(), e );
			setLastError(e);
			e.printStackTrace();
		}
	}

	public void anadirNuevoCoche2(Coche2 c) {
		String sql  = "INSERT INTO coche2 (marca, modelo, color, caballos, numRuedas, nPlazas, precio, motorDiesel, kilometros)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;

		try {			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, c.getMarca());
			stmt.setString(2, c.getModelo());
			stmt.setString(3, c.getColorString());
			stmt.setInt(4, c.getCaballos());
			stmt.setInt(5, c.getNumRuedas());
			stmt.setInt(6, c.getnPlazas());
			stmt.setInt(7, c.getPrecio());

			if (c.isMotorDiesel()) {
				stmt.setInt(8, 1);
			}else {
				stmt.setInt(8, 0);
			}

			stmt.setInt(9, c.getKilometros());

			stmt.executeUpdate();

			log(Level.INFO, "El coche de segunda mano " + c.toString() + " ha sido añadido", null);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error al insertar el coche de segunda mano " + c.toString(), e );
			setLastError(e);
			e.printStackTrace();
		}
	}

	public void anadirNuevaMoto(Moto m) {
		String sql  = "INSERT INTO moto (marca, modelo, color, caballos, numRuedas, nPlazas, precio, estructuraProtectora)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;

		try {			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, m.getMarca());
			stmt.setString(2, m.getModelo());
			stmt.setString(3, m.getColorString());
			stmt.setInt(4, m.getCaballos());
			stmt.setInt(5, m.getNumRuedas());
			stmt.setInt(6, m.getnPlazas());
			stmt.setInt(7, m.getPrecio());

			if (m.isEstructuraProtectora()) {
				stmt.setInt(8, 1);
			}else {
				stmt.setInt(8, 0);
			}

			stmt.executeUpdate();

			log(Level.INFO, "La moto " + m.toString() + " ha sido añadido", null);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error al insertar la moto " + m.toString(), e );
			setLastError(e);
			e.printStackTrace();
		}
	}

	public void anadirNuevaMoto2(Moto2 m) {
		String sql  = "INSERT INTO moto2 (marca, modelo, color, caballos, numRuedas, nPlazas, precio, estructuraProtectora, kilometros)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;

		try {			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, m.getMarca());
			stmt.setString(2, m.getModelo());
			stmt.setString(3, m.getColorString());
			stmt.setInt(4, m.getCaballos());
			stmt.setInt(5, m.getNumRuedas());
			stmt.setInt(6, m.getnPlazas());
			stmt.setInt(7, m.getPrecio());

			if (m.isEstructuraProtectora()) {
				stmt.setInt(8, 1);
			}else {
				stmt.setInt(8, 0);
			}

			stmt.setInt(9, m.getKilometros());

			stmt.executeUpdate();

			log(Level.INFO, "La moto de segunda mano " + m.toString() + " ha sido añadido", null);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error al insertar la moto de segunda mano " + m.toString(), e );
			setLastError(e);
			e.printStackTrace();
		}
	}

	public void venderCoche(VentaCoche vc) {
		String sql  = "INSERT INTO ventacoche (dNI, coche, precio, matricula, isAutomatico, isLucesLed, isTechoPanoramico, isTraccion4x4, isModoDeportivo)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;

		try {			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, vc.getComprador().getdNI());
			stmt.setString(2, vc.getVehiculo().toString());
			stmt.setInt(3, vc.getPrecio());
			stmt.setString(4, vc.getMatricula());

			if (vc.isAutomatico()) {
				stmt.setInt(5, 1);
			} else {
				stmt.setInt(5, 0);
			}

			if (vc.isLucesLed()) {
				stmt.setInt(6, 1);
			} else {
				stmt.setInt(6, 0);
			}

			if (vc.isTechoPanoramico()) {
				stmt.setInt(7, 1);
			} else {
				stmt.setInt(7, 0);
			}

			if (vc.isTraccion4x4()) {
				stmt.setInt(8, 1);
			} else {
				stmt.setInt(8, 0);
			}

			if (vc.isModoDeportivo()){
				stmt.setInt(9, 1);
			} else {
				stmt.setInt(9, 0);
			}

			stmt.executeUpdate();

			log(Level.INFO, "La compra del cliente con DNI " + vc.getComprador().getdNI() + " del coche " + vc.getVehiculo().toString() + " por un valor de " + vc.getPrecio() + " ha sido añadida", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "La compra del cliente con DNI " + vc.getComprador().getdNI() + " del coche " + vc.getVehiculo().toString() + " por un valor de " + vc.getPrecio() + " no ha podido ser añadida", e );
			setLastError(e);
			e.printStackTrace();
		}
	}
	public void venderMoto(VentaMoto vm) {
		String sql  = "INSERT INTO ventamoto (dNI, moto, precio, matricula, isAutomatico, isLucesLed, isEscape, isParamanos, isGuardabarrosGrande)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;

		try {			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, vm.getComprador().getdNI());
			stmt.setString(2, vm.getVehiculo().toString());
			stmt.setInt(3, vm.getPrecio());
			stmt.setString(4, vm.getMatricula());

			if (vm.isAutomatico()) {
				stmt.setInt(5, 1);
			} else {
				stmt.setInt(5, 0);
			}

			if (vm.isLucesLed()) {
				stmt.setInt(6, 1);
			} else {
				stmt.setInt(6, 0);
			}

			if (vm.isEscape()) {
				stmt.setInt(7, 1);
			} else {
				stmt.setInt(7, 0);
			}

			if (vm.isParamanos()) {
				stmt.setInt(8, 1);
			} else {
				stmt.setInt(8, 0);
			}

			if (vm.isGuardabarrosGrande()){
				stmt.setInt(9, 1);
			} else {
				stmt.setInt(9, 0);
			}

			stmt.executeUpdate();

			log(Level.INFO, "La compra del cliente con DNI " + vm.getComprador().getdNI() + " de la moto " + vm.getVehiculo().toString() + " por un valor de " + vm.getPrecio() + " ha sido añadida", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "La compra del cliente con DNI " + vm.getComprador().getdNI() + " de la moto " + vm.getVehiculo().toString() + " por un valor de " + vm.getPrecio() + " no ha podido ser añadida", e );
			setLastError(e);
			e.printStackTrace();
		}
	}

	public void vender2(Venta2 v) {
		String sql = "";
		String logger = "";
		String loggerf = "";

		if (v.getVehiculo() instanceof Coche2) {
			sql  = "INSERT INTO ventacoche2 (dNI, coche, precio, matricula, kilometros) VALUES (?,?,?,?,?)";
			logger = "La compra del cliente con DNI " + v.getComprador().getdNI() + " del coche " + v.getVehiculo().toString() + " por un valor de " + v.getPrecio() + " ha sido añadida";
			loggerf = "La compra del cliente con DNI " + v.getComprador().getdNI() + " del coche " + v.getVehiculo().toString() + " por un valor de " + v.getPrecio() + " no ha podido ser añadida";

		}else if (v.getVehiculo() instanceof Moto2) {
			sql  = "INSERT INTO ventamoto2 (dNI, moto, precio, matricula, kilometros) VALUES (?,?,?,?,?)";
			logger = "La compra del cliente con DNI " + v.getComprador().getdNI() + " de la moto " + v.getVehiculo().toString() + " por un valor de " + v.getPrecio() + " ha sido añadida";
			loggerf = "La compra del cliente con DNI " + v.getComprador().getdNI() + " de la moto " + v.getVehiculo().toString() + " por un valor de " + v.getPrecio() + " no ha podido ser añadida";
		}

		PreparedStatement stmt;

		try {			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, v.getComprador().getdNI());
			stmt.setString(2, v.getVehiculo().toString());
			stmt.setInt(3, v.getPrecio());
			stmt.setString(4, v.getMatricula());
			stmt.setInt(5, v.getKilometros());

			stmt.executeUpdate();

			log(Level.INFO, logger, null);
		} catch (SQLException e) {
			log(Level.SEVERE, loggerf, e );
			setLastError(e);
			e.printStackTrace();
		}
	}

	public ResultSet rellenarTablaTrabajadores(){
		String sql = "SELECT nombre, apellidos, dNI, email, login, fechaNacimiento, sueldo, isAdmin FROM trabajador";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo los trabajadores", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los trabajadores", e);
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet rellenarTablaClientes(){
		String sql = "SELECT nombre, apellidos, dNI, email, login, fechaNacimiento, numTarjeta FROM cliente";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo los clientes", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los clientes", e);
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet rellenarTablaCoches(){
		String sql = "SELECT marca, modelo, color, caballos, nPlazas, precio, motorDiesel FROM coche";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo los coches para rellenar la tabla", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los coches para rellenar la tabla", e);
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet rellenarTablaCoches2(){
		String sql = "SELECT marca, modelo, color, caballos, nPlazas, precio, motorDiesel, kilometros FROM coche2";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo los coches de segunda mano para rellenar la tabla", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los coches de segunda mano para rellenar la tabla", e);
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet rellenarTablaMotos(){
		String sql = "SELECT marca, modelo, color, caballos, nPlazas, precio, estructuraProtectora FROM moto";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo las motos para rellenar la tabla", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener las motos para rellenar la tabla", e);
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet rellenarTablaMotos2(){
		String sql = "SELECT marca, modelo, color, caballos, nPlazas, precio, estructuraProtectora, kilometros FROM moto2";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo las motos de segunda mano para rellenar la tabla", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener las motos de segunda mano para rellenar la tabla", e);
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet rellenarTablaVentasCoches(){
		String sql = "SELECT dNI, coche, precio, matricula, isAutomatico, isLucesLed, isTechoPanoramico, isTraccion4x4, isModoDeportivo FROM ventacoche";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo las ventas de los coches", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener las ventas de los coches", e);
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet rellenarTablaVentasCoches2(){
		String sql = "SELECT dNI, coche, precio, matricula, kilometros FROM ventacoche2";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo las ventas de los coches de segunda mano", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener las ventas de los coches de segunda mano", e);
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet rellenarTablaVentasMotos(){
		String sql = "SELECT dNI, moto, precio, matricula, isAutomatico, isLucesLed, isEscape, isParamanos, isGuardabarrosGrande FROM ventamoto";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo las ventas de las motos", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener las ventas de las motos", e);
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet rellenarTablaVentasMotos2(){
		String sql = "SELECT dNI, moto, precio, matricula, kilometros FROM ventamoto2";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo las ventas de las motos de segunda mano", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener las ventas de las motos de segunda mano", e);
			e.printStackTrace();
		}
		return null;
	}
	//Método que nos permite eliminar a un cliente o despedir a un trabajador, en función de la tabla que le pasemos y el DNI
	public void eliminarPersona(String tabla, String dNI) {
		String sqlBorrar= "DELETE FROM " + tabla + " WHERE dNI = ?";

		PreparedStatement stmtBorrar;

		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);

			stmtBorrar.setString(1, dNI);

			stmtBorrar.executeUpdate();

			log(Level.INFO, "El " + tabla + " con DNI " + dNI + " ha sido borrado correctamente", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "No ha sido posible borrar al " + tabla + " con DNI " + dNI, e);
			e.printStackTrace();
		}
	}

	//Método para borrar un vehículo de la bbdd en función de la tabla y otros valores
	public void eliminarCoche(String marca, String modelo, String color, int caballos, int plazas, int precio, int diesel) {
		String sqlBorrar= "DELETE FROM coche WHERE marca = ? AND modelo = ? AND color = ? "
				+ "AND caballos = ? AND nPlazas = ? AND motorDiesel = ?";

		PreparedStatement stmtBorrar;

		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);

			stmtBorrar.setString(1, marca);
			stmtBorrar.setString(2, marca);
			stmtBorrar.setString(3, color);
			stmtBorrar.setInt(4, caballos);
			stmtBorrar.setInt(5, plazas);
			stmtBorrar.setInt(6, diesel);

			stmtBorrar.executeUpdate();

			log(Level.INFO, "El " + marca + " " + modelo + " de color " + color.toLowerCase() + " ha sido borrado correctamente", null);
		} catch (SQLException e) { 
			log(Level.SEVERE, "No ha sido posible borrar el "  + marca + " " + modelo + " de color " + color.toLowerCase() , e);
			e.printStackTrace();
		}
	}

	public void eliminarCoche2(String marca, String modelo, String color, int caballos, int plazas, int precio, int diesel, int kilometros) {
		String sqlBorrar= "DELETE FROM coche WHERE marca = ? AND modelo = ? AND color = ? "
				+ "AND caballos = ? AND nPlazas = ? AND motorDiesel = ? AND kilometros = ?";

		PreparedStatement stmtBorrar;

		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);

			stmtBorrar.setString(1, marca);
			stmtBorrar.setString(2, marca);
			stmtBorrar.setString(3, color);
			stmtBorrar.setInt(4, caballos);
			stmtBorrar.setInt(5, plazas);
			stmtBorrar.setInt(6, diesel);
			stmtBorrar.setInt(7, kilometros);

			stmtBorrar.executeUpdate();

			log(Level.INFO, "El " + marca + " " + modelo + " de color " + color.toLowerCase() + " con " + kilometros + " kilometros ha sido borrado correctamente", null);
		} catch (SQLException e) { 
			log(Level.SEVERE, "No ha sido posible borrar el "  + marca + " " + modelo + " de color " + color.toLowerCase() +  " con " + kilometros + " kilometros", e);
			e.printStackTrace();
		}
	}

	public void eliminarMoto(String marca, String modelo, String color, int caballos, int plazas, int precio, int estructura) {
		String sqlBorrar= "DELETE FROM moto WHERE marca = ? AND modelo = ? AND color = ? "
				+ "AND caballos = ? AND nPlazas = ? AND estructuraProtectora = ?";

		PreparedStatement stmtBorrar;

		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);

			stmtBorrar.setString(1, marca);
			stmtBorrar.setString(2, marca);
			stmtBorrar.setString(3, color);
			stmtBorrar.setInt(4, caballos);
			stmtBorrar.setInt(5, plazas);
			stmtBorrar.setInt(6, estructura);

			stmtBorrar.executeUpdate();

			log(Level.INFO, "La " + marca + " " + modelo + " de color " + color.toLowerCase() + " ha sido borrada correctamente", null);
		} catch (SQLException e) { 
			log(Level.SEVERE, "No ha sido posible borrar la "  + marca + " " + modelo + " de color " + color.toLowerCase() , e);
			e.printStackTrace();
		}
	}

	public void eliminarMoto2(String marca, String modelo, String color, int caballos, int plazas, int precio, int estructura, int kilometros) {
		String sqlBorrar= "DELETE FROM moto WHERE marca = ? AND modelo = ? AND color = ? "
				+ "AND caballos = ? AND nPlazas = ? AND estructuraProtectora = ? AND kilometros = ?";

		PreparedStatement stmtBorrar;

		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);

			stmtBorrar.setString(1, marca);
			stmtBorrar.setString(2, marca);
			stmtBorrar.setString(3, color);
			stmtBorrar.setInt(4, caballos);
			stmtBorrar.setInt(5, plazas);
			stmtBorrar.setInt(6, estructura);

			stmtBorrar.executeUpdate();

			log(Level.INFO, "La " + marca + " " + modelo + " de color " + color.toLowerCase() + "con " + kilometros + " kilometros ha sido borrada correctamente", null);
		} catch (SQLException e) { 
			log(Level.SEVERE, "No ha sido posible borrar la "  + marca + " " + modelo + " de color " + color.toLowerCase() + "con " + kilometros + " kilometros" , e);
			e.printStackTrace();
		}
	}

	public void eliminarVenta(String tabla, String dni, int precio, String matricula) {
		String sqlBorrar= "DELETE FROM " + tabla + " WHERE dNI = ? AND precio = ? AND matricula = ?";

		PreparedStatement stmtBorrar;

		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);

			stmtBorrar.setString(1, dni);
			stmtBorrar.setInt(2, precio);
			stmtBorrar.setString(3, matricula);

			stmtBorrar.executeUpdate();

			log(Level.INFO, "La venta del vehiculo con matrícula " + matricula + " realizada por el cliente con DNI " + dni + " ha sido borrada correctamente", null);
		} catch (SQLException e) { 
			log(Level.SEVERE, "No ha sido posible borrar la venta del vehiculo con matrícula " + matricula + " realizada por el cliente con DNI " + dni, e);
			e.printStackTrace();
		}
	}

	// Método público para asignar un logger externo
	public static void setLogger( Logger logger ) {
		GestorBD.logger = logger;
	}
	// Método local para loggear (si no se asigna un logger externo, se asigna uno local)
	private static void log( Level level, String msg, Throwable excepcion ) {
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

	public static Exception getLastError() {
		return lastError;
	}

	public static void setLastError(Exception lastError) {
		GestorBD.lastError = lastError;
	}
}