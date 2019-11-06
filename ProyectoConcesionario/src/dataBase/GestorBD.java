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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void desconectar(){
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void iniciarBBDDTrabajadoresFichero(List<Trabajador> trabajadores) throws SQLException {
		//TODO crear test de prueba
		Iterator<Trabajador>it = trabajadores.iterator();
		
		String sql  = "INSERT INTO trabajador (login, password, email, dNI, nombre, apellidos, fechaNacimiento, sueldo)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
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
	}
	
	public void iniciarBBDDClientesFichero(List<Cliente> clientes) throws SQLException {
		//TODO crear test de prueba
		Iterator<Cliente>it = clientes.iterator();
		
		String sql  = "INSERT INTO cliente (login, password, email, dNI, nombre, apellidos, fechaNacimiento, numTarjeta)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
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
	}
	
	public List<Trabajador> obtenerTrabajadores() throws SQLException, ParseException{
		//TODO crear test de prueba
		String sql = "SELECT login, password, email, dNI, nombre, apellidos, fechaNacimiento, sueldo FROM trabajador";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			Trabajador t = new Trabajador();
			t.setLogin(rs.getString("login"));
			t.setPassword(rs.getString("password"));
			t.setEmail(rs.getString("email"));
			t.setdNI(rs.getString("dNI"));
			t.setNombre(rs.getString("nombre"));
			t.setApellidos(rs.getString("apellidos"));
			t.setFechaNacimientoString(rs.getString("fechaNacimiento"));
			t.setSueldo(rs.getInt("sueldo"));
			
			trabajadores.add(t);
		}
		return trabajadores;
	}
	
	public List<Cliente> obtenerClientes() throws SQLException, ParseException{
		//TODO crear test de prueba
		String sql = "SELECT login, password, email, dNI, nombre, apellidos, fechaNacimiento, numTarjeta FROM cliente";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			Cliente c = new Cliente();
			c.setLogin(rs.getString("login"));
			c.setPassword(rs.getString("password"));
			c.setEmail(rs.getString("email"));
			c.setdNI(rs.getString("dNI"));
			c.setNombre(rs.getString("nombre"));
			c.setApellidos(rs.getString("apellidos"));
			c.setFechaNacimientoString(rs.getString("fechaNacimiento"));
			c.setNumTarjeta(rs.getLong("numTarjeta"));
			
			clientes.add(c);
		}
		return clientes;
	}
	
	public boolean iniciarSesionCliente(String usuario, String contra) throws SQLException {
		//TODO iniciar sesión clientes
		String sql = "SELECT login, password FROM cliente";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
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
					return true;
				}
			}	
		}
		return false;
	}
	
	public boolean iniciarSesionTrabajador(String usuario, String contra) throws SQLException {
		//TODO iniciar sesión trabajadores
		String sql = "SELECT login, password FROM trabajador";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			Trabajador t = new Trabajador();
			t.setLogin(rs.getString("login"));
			t.setPassword(rs.getString("password"));
			
			trabajadores.add(t);
		}
		
		Iterator<Trabajador> itTrabajadores = trabajadores.iterator();
		
		while (itTrabajadores.hasNext()) {
			Trabajador t = new Trabajador();
			
			String login = t.getLogin();
			String password = t.getPassword();
			
			if (login.equals(usuario)) {
				if (password.equals(contra)) {
					return true;
				}
			}	
		}
		return false;
	}
	
	public void anadirNuevoCliente(Cliente c) throws SQLException {
		//TODO crear un nuevo cliente
		String sql  = "INSERT INTO cliente (login, password, email, dNI, nombre, apellidos, fechaNacimiento, numTarjeta)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
			
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
	
	public void anadirNuevoTrabajador(Trabajador t) throws SQLException {
		//TODO crear un nuevo trabajador
		String sql  = "INSERT INTO trabajador (login, password, email, dNI, nombre, apellidos, fechaNacimiento, sueldo)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sql);


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
}
