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

import model.Cliente;
import model.Trabajador;

public class GestorBD {
	private Connection conn;

	public GestorBD() {
		conectar();
	}

	private void conectar(){
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:ficheros/baseDeDatos.db");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
		//TODO crear un nuevo cliente
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void anadirNuevoTrabajador(Trabajador t) {
		//TODO crear un nuevo trabajador
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
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
}
