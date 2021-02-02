package gestionDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
			// fin creación bd
			
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
	
	/** Borra todo el contenido de la tabla eventos
	 */
	public static void resetEventos() {
		try (Statement statement = conexion.createStatement()) {
			String sent = "DELETE FROM evento;VACUUM;";
			statement.executeUpdate( sent );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Guarda un evento en la base de datos.
	 * Lo inserta si no existe comprobando antes que el barco esté en su tabla correspondiente
	 * @return	Devuelve true si es correcto y false si ha ocurrido algún error
	 */
	public static boolean addEvento(Evento e) {
		//T1b - Carga de evento en la base de datos

		return false;
	}
	
}
