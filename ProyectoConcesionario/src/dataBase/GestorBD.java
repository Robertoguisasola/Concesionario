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
import model.Persona;
import model.Trabajador;

public class GestorBD {
private Connection conn;
	
	public void conectar() throws ClassNotFoundException, SQLException{
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:ficheros/baseDeDatos.db");
	}
	
	public void desconectar() throws SQLException{
		conn.close();
	}
	
	public void iniciarBBDDtrabajadores(List<Trabajador> trabajadores) throws SQLException {
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
	
	public void iniciarBBDDclientes(List<Cliente> clientes) throws SQLException {
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
		//TODO modificar valores según las tablas
		String sql = "SELECT nombre, apellidos, dNI FROM trabajadores";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			Trabajador t = new Trabajador();
			t.setNombre(rs.getString("nombre"));
			t.setApellidos(rs.getString("apellidos"));
			t.setdNI(rs.getString("dNI"));
			
			trabajadores.add(t);
		}
		return trabajadores;
	}
}
