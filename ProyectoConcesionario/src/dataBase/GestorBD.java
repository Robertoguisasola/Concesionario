package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.Persona;

public class GestorBD {
private Connection conn;
	
	public void conectar() throws ClassNotFoundException, SQLException{
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:ficheros/baseDeDatos.db");
	}
	
	public void desconectar() throws SQLException{
		conn.close();
	}
	
	public void iniciarBBDDpersonas() throws SQLException {
		//TODO modificar valores según las tablas
		String sql  = "INSERT INTO persona (persona, password, creation_date) VALUES (?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		Persona persona= new Persona();
		
		stmt.setString(1, persona.getLogin());
		stmt.setString(2, persona.getPassword());
		stmt.setString(3, persona.getEmail());
		
		stmt.executeUpdate();
	}
	
	public List<Persona> obtenerpersonas() throws SQLException, ParseException{
		String sql = "SELECT login, password, email, dni FROM persona";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		List<Persona> personas = new ArrayList<Persona>();
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			Persona persona = new Persona();
			persona.setLogin(rs.getString("login"));
			persona.setPassword(rs.getString("password"));
			persona.setEmail(rs.getString("email"));
			
			personas.add(persona);
		}
		
		return personas;
	}
	

}
