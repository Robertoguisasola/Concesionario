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
import model.Trabajador;

public class GestorBD {
	//TODO m�todo de a�adir coche de 2� mano

	private static Exception lastError = null; //�ltimo error que ha sucedido
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
			log(Level.SEVERE, "Error en conexi�n de base de datos ", e);
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

	//Preparado para tener no solo ventas de coches
	private void borrarVentas(String[] tablas) {
		for (int i = 0; i < tablas.length; i++) {
			borrar(tablas[i]);
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
		String [] tablas = {"ventacoche"};

		if (tabla.equals("venta")) {
			borrarVentas(tablas);
		} else {
			borrar(tabla);			
		}

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
		case "venta":
			importarVentas();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Pongase en contacto con el desarrollador para importar este fichero");
			break;
		}
	}

	public void exportarBBDDAFichero(String tabla) {	
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
		case "venta":
			System.out.println("exportar venta");
			exportarVentas();
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
				t.setAdmin(Boolean.parseBoolean(campos[8]));

				trabajadores.add(t);
			}
			sc.close();

			log(Level.INFO, "Trabajadores cargados desde el fichero", null);
		} catch (Exception e) {
			log(Level.SEVERE, "Error al cargar trabajadores desde el fichero", null);
		}

		//TODO tttt crear test de prueba
		Iterator<Trabajador>it = trabajadores.iterator();


		while (it.hasNext()){			
			Trabajador t  = it.next();

			anadirNuevoTrabajador(t);
		}
		log(Level.INFO, "Trabajadores a�adidos a la base de datos", null);
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

			log(Level.INFO, "Clientes cargados desde el fichero", null);
		} catch (Exception e) {
			e.printStackTrace();
			log(Level.SEVERE, "Error al cargar los clientes desde el fichero", null);
		} finally {
			sc.close();
		}

		//TODO tttt crear test de prueba
		Iterator<Cliente>it = clientes.iterator();

		while (it.hasNext()){			
			Cliente c  = it.next();

			anadirNuevoCliente(c);
		}
		log(Level.INFO, "Clientes a�adidos a la base de datos", null);
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

				//Cada campo est� partido por ;
				Coche c = new Coche();

				String[] campos = linea.split(";");// recibe un argumento y devuleve un array de Strings

				c.setMarca(campos[0]);
				c.setModelo(campos[1]);
				c.setColor(campos[2].toLowerCase());
				c.setCaballos(Integer.parseInt(campos[3]));
				c.setNumRuedas(Integer.parseInt(campos[4]));
				c.setnPlazas(Integer.parseInt(campos[5]));
				c.setMotorDiesel(Boolean.parseBoolean(campos[6]));

				coches.add(c);
			}
			log(Level.INFO, "Coches cargados desde el fichero", null);
		} catch (Exception e) {
			e.printStackTrace();
			log(Level.SEVERE, "Error al cargar los coches desde el fichero", null);
		} finally {
			sc.close();
		}

		//TODO tttt crear test de prueba
		Iterator<Coche>it = coches.iterator();

		while (it.hasNext()){			
			Coche c  = it.next();

			anadirNuevoCoche(c);
		}
		log(Level.INFO, "Clientes a�adidos a la base de datos", null);
	}
	
	//TODO aaaa completar importar
	private void importarVentas() {
		
	}

	private void exportarTrabajadores(){
		//TODO ffff modificar el fichero si funciona bien, para ver si conseguimos que se sobreescriban
		FileWriter f = null;
		List<Trabajador>trabajadores = obtenerTrabajadores();

		try {
			f = new FileWriter("ficheros/trabajadoresexp.csv");

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
			f = new FileWriter("ficheros/clientesexp.csv");

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
			f = new FileWriter("ficheros/cochesexp.csv");

			for (Coche c : coches) {
				String marca = c.getMarca();
				String modelo = c.getModelo();
				String color = c.getColor().toString();
				int caballos = c.getCaballos();
				int numRuedas = c.getNumRuedas();
				int nPlazas = c.getnPlazas();
				boolean motorDiesel = c.isMotorDiesel();

				f.write(marca + ";" + modelo + ";" + color + ";" + caballos + ";" + numRuedas + ";" + nPlazas + ";"+ motorDiesel + "\n");

				log(Level.INFO, "El coche " + c.toString() + " ha sido exportado correctamente", null);
			}

			log(Level.INFO, "Coches exportados", null);
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

	//TODO aaaa terminar
	private void exportarVentas() {
		
	}
	public List<Trabajador> obtenerTrabajadores(){
		//TODO tttt crear test de prueba
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
		//TODO tttt crear test de prueba
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
		//TODO tttt crear test de prueba
		String sql = "SELECT marca, modelo, color, caballos, numRuedas, nPlazas, motorDiesel FROM coche";
		PreparedStatement stmt;

		List<Coche> coches = new ArrayList<Coche>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Coche c = new Coche();
				c.setMarca(rs.getString("marca"));
				c.setModelo(rs.getString("modelo"));
				c.setColor(rs.getString("color"));
				c.setCaballos(rs.getInt("caballos"));
				c.setNumRuedas(rs.getInt("numRuedas"));
				c.setnPlazas(rs.getInt("nPlazas"));
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

			log(Level.INFO, "El cliente " + c.getNombre() + " ha sido a�adido", null);
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

			log(Level.INFO, "El trabajador " + t.getNombre() + " ha sido a�adido", null);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error al insertar el trabajador" + sql, e );
			setLastError(e);
			e.printStackTrace();
		}
	}

	public void anadirNuevoCoche(Coche c) {
		String sql  = "INSERT INTO coche (marca, modelo, color, caballos, numRuedas, nPlazas, motorDiesel)"
				+ " VALUES (?,?,?,?,?,?,?)";

		PreparedStatement stmt;

		try {			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, c.getMarca().toLowerCase());
			stmt.setString(2, c.getModelo().toUpperCase());
			stmt.setString(3, c.getColor().toString().toLowerCase());
			stmt.setInt(4, c.getCaballos());
			stmt.setInt(5, c.getNumRuedas());
			stmt.setInt(6, c.getnPlazas());
			if (c.isMotorDiesel()) {
				stmt.setInt(7, 1);
			}else {
				stmt.setInt(7, 0);
			}

			stmt.executeUpdate();

			log(Level.INFO, "El coche " + c.toString() + " ha sido a�adido", null);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error al insertar el trabajador" + sql, e );
			setLastError(e);
			e.printStackTrace();
		}
	}

	public ResultSet rellenarTablaTrabajadores(){
		//TODO tttt crear test de prueba
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
		//TODO tttt crear test de prueba
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
		//TODO tttt crear test de prueba
		String sql = "SELECT marca, modelo, color, caballos, nPlazas, motorDiesel FROM coche";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo los coches", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los coches", e);
			e.printStackTrace();
		}
		return null;
	}

	//M�todo que nos permite eliminar a un cliente o despedir a un trabajador, en funci�n de la tabla que le pasemos y el DNI
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

	//M�todo para borrar un veh�culo de la bbdd en funci�n de la tabla y otros valores
	public void eliminarVehiculo(String tabla, String marca, String modelo, String color, int caballos, int plazas, int diesel) {
		String sqlBorrar= "DELETE FROM " + tabla + " WHERE marca = ? AND modelo = ? AND color = ? "
				+ "AND caballos = ? AND nPlazas = ? AND motorDiesel = ?";

		PreparedStatement stmtBorrar;

		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);

			stmtBorrar.setString(1, marca);
			stmtBorrar.setString(2, modelo);
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

	//TODO completar m�todo....
	public void venderCoche() {

	}

	// M�todo p�blico para asignar un logger externo
	public static void setLogger( Logger logger ) {
		GestorBD.logger = logger;
	}
	// M�todo local para loggear (si no se asigna un logger externo, se asigna uno local)
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
