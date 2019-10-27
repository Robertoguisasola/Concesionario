package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class GestorBD {
private Connection conn;
	
	public void conectar() throws ClassNotFoundException, SQLException{
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:ficheros/baseDeDatos.db");
	}
	
	public void desconectar() throws SQLException{
		conn.close();
	}
	
	public List<Usuario> obtenerUsuarios() throws SQLException, ParseException{
		String sql = "SELECT login, password, email, dni FROM usuario";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			Usuario usuario = new Usuario();
			usuario.setLogin(rs.getString("login"));
			usuario.setPassword(rs.getString("password"));
			usuario.setEmail(rs.getString("email"));
			
			usuarios.add(usuario);
		}
		
		return usuarios;
	}
	

}
