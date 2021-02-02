package gestionDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import datos.Barco;
import datos.Evento;
import datos.TipoBarco;
import datos.TipoEvento;

public class BaseDatos {
	private static Connection conexion;
	
	/** Abre conexión con la base de datos
	 * @param nombreBD	Nombre del fichero de base de datos
	 * @return	true si la conexión ha sido correcta, false en caso contrario
	 */
	public static boolean abrirConexion( String nombreBD ) {
		try {
			System.out.println( "Conexión abierta" );
			Class.forName("org.sqlite.JDBC");  // Carga la clase de BD para sqlite
			conexion = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			
			// Creación de las tablas
			Statement statement = conexion.createStatement();
			String sent = "CREATE TABLE IF NOT EXISTS barco (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre varchar(100), codigo varchar(100), tipo varchar(100), email varchar(100), oceano varchar(100));";
			statement.executeUpdate( sent );
			sent = "CREATE TABLE IF NOT EXISTS evento (id INTEGER PRIMARY KEY AUTOINCREMENT, codigoBarco varchar(100), tipo varchar(100), fecha int);";
			statement.executeUpdate( sent );
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/** Cierra la conexión abierta de base de datos
	 */
	public static void cerrarConexion() {
		try {
			conexion.close();
			System.out.println( "Conexión cerrada" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Lee los barcos de la conexión de base de datos abierta
	 * @return	Lista completa de barcos, null si hay algún error
	 */
	public static ArrayList<Barco> getBarcos() {
		try (Statement statement = conexion.createStatement()) {
			ArrayList<Barco> barcos = new ArrayList<>();
			String sent = "select * from barco;";
			System.out.println( sent );
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { // Leer el resultset
				String nombre = rs.getString("nombre");
				String codigo = rs.getString("codigo");
				String tipo = rs.getString("tipo");
				String oceano = rs.getString("oceano");
				barcos.add( new Barco ( nombre, null, codigo, TipoBarco.valueOf(tipo), oceano ) );
			}
			return barcos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** Lee los eventos de la conexión de base de datos abierta
	 * @return	Lista completa de eventos, null si hay algún error
	 */
	public static ArrayList<Evento> getEventos() {
		try (Statement statement = conexion.createStatement()) {
			ArrayList<Evento> eventos = new ArrayList<>();
			String sent = "select * from evento;";
			System.out.println( sent );
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { // Leer el resultset
				String codigoBarco = rs.getString("codigoBarco");
				long fecha = rs.getLong("fecha");
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTimeInMillis(fecha);
				String tipo = rs.getString("tipo");
				eventos.add( new Evento ( codigoBarco, cal, TipoEvento.valueOf(tipo) ) );
			}
			return eventos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	public static ArrayList<Evento> getEventosBarco(String b) {
		try (Statement statement = conexion.createStatement()) {
			ArrayList<Barco> barcos = new ArrayList<>();
			Barco bb = null;
			String sent = "select * from barco;";
			System.out.println( sent );
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { // Leer el resultset
				String nombre = rs.getString("nombre");
				String codigo = rs.getString("codigo");
				String tipo = rs.getString("tipo");
				String oceano = rs.getString("oceano");
				barcos.add( new Barco ( nombre, null, codigo, TipoBarco.valueOf(tipo), oceano ) );
			}
			
			Iterator<Barco> bar= barcos.iterator();
			while (bar.hasNext()) {
				Barco b2 = bar.next();
				
				if (b2.getNombre().equals(b)) {
					bb = b2;
				}
			}
			
			ArrayList<Evento> eventos = new ArrayList<>();
			String sent2 = "select * from evento where codigoBarco = '" + bb.getCodigo() + "';";
			System.out.println( sent2 );
			ResultSet rs2 = statement.executeQuery( sent2 );
			
			while( rs2.next() ) { // Leer el resultset
				String codigoBarco = rs.getString("codigoBarco");
				long fecha = rs.getLong("fecha");
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTimeInMillis(fecha);
				String tipo = rs.getString("tipo");
				eventos.add( new Evento ( codigoBarco, cal, TipoEvento.valueOf(tipo) ) );
			}
			return eventos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
}
