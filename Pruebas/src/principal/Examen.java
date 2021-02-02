package principal;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.SwingUtilities;

import datos.Barco;
import datos.Evento;
import gestionDatos.BaseDatos;
import ventanas.VentanaDatos;
/** Clase principal del examen
 */
public class Examen {
	public static ArrayList<Barco> lBarcos = new ArrayList<>();
	public static ArrayList<Evento> lEventos = new ArrayList<>();
	
	public static void main(String[]args) {
		//Cargamos los datos de la base de datos existente.
		BaseDatos.abrirConexion("gestionbarcos.db");
		lBarcos = BaseDatos.getBarcos();
		lEventos = BaseDatos.getEventos();
		BaseDatos.cerrarConexion();
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaDatos();
            }
        });
	}

	// Métodos de ayuda - No modificar
	
	/** Método que devuelve un listado de los océanos disponibles en los datos cargados.
	 * @return Arraylist de String con los océanos
	 */
	public static ArrayList<String> getOceanos() {
		HashSet<String> uniqueValues = new HashSet<>();
		for (Barco b : lBarcos) {
		   uniqueValues.add(b.getOceano());
		}
		return new ArrayList<String>(uniqueValues);
	}
	/** Método que devuelve un listado de los barcos de un océano
	 * @return Arraylist de String con los barcos
	 */
	public static ArrayList<Barco> getBarcosOceano(String oceano) {
		ArrayList<Barco> listaBarcos = new ArrayList<>();
		for (Barco b : lBarcos) {
		   if(b.getOceano().equals(oceano)) listaBarcos.add(b);
		}
		return listaBarcos;
	}
}
