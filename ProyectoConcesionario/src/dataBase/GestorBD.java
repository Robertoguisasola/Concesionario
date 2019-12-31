package dataBase;

import java.io.File;
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

import model.Cliente;
import model.Trabajador;

public class GestorBD {
	//TODO métodos para exportar a ficheros
	//TODO método de añadir coche
	//TODO método de añadir coche de 2ª mano
	//TODO método crear venta
	//TODO método ver ventas
	//TODO poner loggers

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
	
	public void importarFicheroABBDD(String tabla){
		String sqlBorrar  = "DELETE FROM " + tabla;

		Statement stmtBorrar;
		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);	

			stmtBorrar.executeUpdate(sqlBorrar);

			switch (tabla) {
			//Acaba en consonante
			case "trabajador":
				log(Level.INFO, "Borrado de " + tabla + "es de la base de datos", null);
				break;
			//Acaba en vocal
			default:
				log(Level.INFO, "Borrado de " + tabla + "s de la base de datos", null);
				break;
			}
		} catch (SQLException e) {
			switch (tabla) {
			//Acaba en consonante
			case "trabajador":
				log(Level.SEVERE, "Error al borrar " + tabla + "es a la base de datos", e);
				e.printStackTrace();
				break;
			//Acaba en vocal
			default:
				log(Level.SEVERE, "Error al borrar " + tabla + "s a la base de datos", e);
				e.printStackTrace();
				break;
			}
		}

		List<Trabajador> trabajadores = new ArrayList<Trabajador>();

		try {
			File f;
			switch (tabla) {
			case "trabajador":
				f = new File("ficheros/trabajadores.csv");
				break;
			case "cliente":
				f = new File("ficheros/clientes.csv");
				break;
			case "coche":
				f = new File("ficheros/coches.csv");
			case "venta":
				f = new File("ficheros/ventas.csv");
				break;
			default:
				break;
			}
			f = new File("ficheros/trabajadores.csv");
			Scanner sc = new Scanner(f);

			//TODO aaaaa hacer el switch para cualquier objeto
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

				log(Level.INFO, "Trabajadores cargados desde el fichero", null);
			}
			sc.close();
		} catch (Exception e) {
			log(Level.SEVERE, "Error al cargar trabajadores desde el fichero", null);
		}

		//TODO crear test de prueba
		Iterator<Trabajador>it = trabajadores.iterator();

		String sql  = "INSERT INTO trabajador (login, password, email, dNI, nombre, apellidos, fechaNacimiento, sueldo)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);

			while (it.hasNext()){			
				Trabajador t  = it.next();

				stmt.setString(1, t.getLogin());
				stmt.setString(2, t.getPassword());
				stmt.setString(3, t.getEmail());
				stmt.setString(4, t.getdNI());
				stmt.setString(5, t.getNombre());
				stmt.setString(6, t.getApellidos());
				stmt.setString(7, t.getFechaNacimientoString());
				stmt.setInt(8, t.getSueldo());

				stmt.executeUpdate();
			}
			log(Level.INFO, "Trabajadores añadidos a la base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al añador los trabajadores a la base de datos", e);
			e.printStackTrace();
		}
	}	

	public void importarBBDDTrabajadoresFichero(){
		String sqlBorrar  = "DELETE FROM trabajador";

		Statement stmtBorrar;
		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);	

			stmtBorrar.executeUpdate(sqlBorrar);

			log(Level.INFO, "Borrado de trabajadores de la base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al borrar los trabajadores a la base de datos", e);
			e.printStackTrace();
		}

		List<Trabajador> trabajadores = new ArrayList<Trabajador>();

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

				log(Level.INFO, "Trabajadores cargados desde el fichero", null);
			}
			sc.close();
		} catch (Exception e) {
			log(Level.SEVERE, "Error al cargar trabajadores desde el fichero", null);
		}

		//TODO crear test de prueba
		Iterator<Trabajador>it = trabajadores.iterator();

		String sql  = "INSERT INTO trabajador (login, password, email, dNI, nombre, apellidos, fechaNacimiento, sueldo)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);

			while (it.hasNext()){			
				Trabajador t  = it.next();

				stmt.setString(1, t.getLogin());
				stmt.setString(2, t.getPassword());
				stmt.setString(3, t.getEmail());
				stmt.setString(4, t.getdNI());
				stmt.setString(5, t.getNombre());
				stmt.setString(6, t.getApellidos());
				stmt.setString(7, t.getFechaNacimientoString());
				stmt.setInt(8, t.getSueldo());

				stmt.executeUpdate();
			}
			log(Level.INFO, "Trabajadores añadidos a la base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al añador los trabajadores a la base de datos", e);
			e.printStackTrace();
		}
	}	

	public void importarBBDDClientesFichero() {

		String sqlBorrar  = "DELETE FROM cliente";

		Statement stmtBorrar;
		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);	

			stmtBorrar.executeUpdate(sqlBorrar);
			
			log(Level.INFO, "Borrado de clientes de la base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al borrar los clientes a la base de datos", e);
			e.printStackTrace();
		}

		List<Cliente> clientes = new ArrayList<Cliente>();

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
			
			log(Level.INFO, "Clientes cargados desde el fichero", null);
		} catch (Exception e) {
			e.printStackTrace();
			log(Level.SEVERE, "Error al cargar los clientes desde el fichero", null);
		}

		//TODO crear test de prueba
		Iterator<Cliente>it = clientes.iterator();

		String sql  = "INSERT INTO cliente (login, password, email, dNI, nombre, apellidos, fechaNacimiento, numTarjeta)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);

			while (it.hasNext()){			
				Cliente c  = it.next();

				stmt.setString(1, c.getLogin());
				stmt.setString(2, c.getPassword());
				stmt.setString(3, c.getEmail());
				stmt.setString(4, c.getdNI());
				stmt.setString(5, c.getNombre());
				stmt.setString(6, c.getApellidos());
				stmt.setString(7, c.getFechaNacimientoString());
				stmt.setLong(8, c.getNumTarjeta());

				stmt.executeUpdate();

			}
			log(Level.INFO, "Clientes añadidos a la base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al importar los clientes a la base de datos ", e);
			e.printStackTrace();
		}
	}

	//TODO modificar para que saque un table model y meterlo en la tabla
	public List<Trabajador> obtenerTrabajadores(){
		//TODO crear test de prueba
		String sql = "SELECT login, password, email, dNI, nombre, apellidos, fechaNacimiento, sueldo FROM baseDeDatos.db";
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

				trabajadores.add(t);

			}
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los trabajadores", e);
			e.printStackTrace();
		}


		return trabajadores;
	}

	//TODO modificar para que saque un table model y meterlo en la tabla
	public List<Cliente> obtenerClientes(){
		//TODO crear test de prueba
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
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los clientes", e);
			e.printStackTrace();
		}


		return clientes;
	}

	public Cliente iniciarSesionCliente(String usuario, String contra){
		String sql = "SELECT * FROM cliente";
		PreparedStatement stmt;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){
				//TODO reformatear esto, tiene que rellenar todo de un cliente, aunque no lo use, para luego devolverlo al metodo de iniciarSesion
				Cliente c = new Cliente();
				c.setLogin(rs.getString("login"));
				c.setPassword(rs.getString("password"));
				c.setEmail(rs.getString("email"));

				clientes.add(c);
			}

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

		} catch (SQLException e) {
			log(Level.SEVERE, "Error al iniciar sesión con la cuenta", e);
			e.printStackTrace();
		}	
		return null;
	}

	public Trabajador iniciarSesionTrabajador(String usuario, String contra){
		String sql = "SELECT login, password FROM trabajador";
		PreparedStatement stmt;

		List<Trabajador> trabajadores = new ArrayList<Trabajador>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){
				Trabajador t = new Trabajador();

				t.setLogin(rs.getString("login"));
				t.setPassword(rs.getString("password"));

				trabajadores.add(t);
			}

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

		} catch (SQLException e) {
			log(Level.SEVERE, "Error al iniciar sesión con la cuenta ", e);
			e.printStackTrace();
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
		String sql  = "INSERT INTO trabajador (login, password, email, dNI, nombre, apellidos, fechaNacimiento, sueldo)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

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

			stmt.executeUpdate();

			log(Level.INFO, "El trabajador " + t.getNombre() + " ha sido añadido", null);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error al insertar el trabajador" + sql, e );
			setLastError(e);
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
