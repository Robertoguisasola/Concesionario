package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Cliente;
import model.Trabajador;

public class GestorBD {
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
			log( Level.INFO, "Conectado a la base de datos", null );
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en conexión de base de datos ", e);
			e.printStackTrace();
		}
	}

	public void desconectar(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void importarBBDDTrabajadoresFichero(List<Trabajador> trabajadores){
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
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}	

	public void importarBBDDClientesFichero(List<Cliente> clientes) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
			e.printStackTrace();
		}


		return trabajadores;
	}

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
			e.printStackTrace();
		}


		return clientes;
	}

	public Cliente iniciarSesionCliente(String usuario, String contra){
		String sql = "SELECT login, password FROM cliente";
		PreparedStatement stmt;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){
				Cliente c = new Cliente();
				c.setLogin(rs.getString("login"));
				c.setPassword(rs.getString("password"));

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
			lastError = e;
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
			lastError = e;
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
				logger.addHandler( new FileHandler( "bd.log.xml", true ) );  // Y saca el log a fichero xml
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
