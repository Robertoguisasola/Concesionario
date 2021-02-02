package principal;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.SwingUtilities;
import datos.Barco;
import datos.Evento;
import gestionDatos.BaseDatos;
import gestionDatos.GestionDatos;
import gestionDatos.ProcesoCSV;
import ventanas.VentanaDatos;

public class Examen {
	public static ArrayList<Barco> lBarcos = new ArrayList<>();
	public static ArrayList<Evento> lEventos = new ArrayList<>();
	
	private static void ejercicio1() {
		System.out.println("-> EJERCICIO 1a <-");
		// - T1a - Métodos de prueba
		lEventos = ProcesoCSV.cargarEventos();
		System.out.println("ProcesoCSV: Cargados " + lEventos.size() + " eventos.");
		// ----------------------
		System.out.println("-> EJERCICIO 1b <-");
		// - T1b - Métodos de prueba
		BaseDatos.abrirConexion("gestionbarcos.db");
		BaseDatos.resetEventos(); // Antes de guardar borramos los datos de la tabla eventos
		// Guardado de eventos
		for(Evento e: lEventos) {
			System.out.println(e.toString());
			BaseDatos.addEvento(e);
		}
		System.out.println("BaseDatos: Eventos guardados correctamente");
		BaseDatos.cerrarConexion();
	}
	
	private static void ejercicio3(){
		System.out.println("-> EJERCICIO 3 <-");
		GestionDatos.ordenarEventos();
	}
	
	private static void ejercicio4(){
		System.out.println("-> EJERCICIO 4a <-");
		System.out.println("- Lista sin ordenar:");
		System.out.println(lEventos);
		ArrayList<Evento> lEventosOrdenada = GestionDatos.ordenarEventosMergeSort();
		System.out.println("- Lista ordenada:");
		System.out.println(lEventosOrdenada);
		// ----------------------
		System.out.println("-> EJERCICIO 4b <-");
		for(Barco b: lBarcos) {	//Reiniciamos las mareas de los barcos
			b.resetMareas();
		}
		GestionDatos.generaMareas(lEventosOrdenada);	
		//Mostramos las mareas generadas en cada barco
		System.out.println("- Mareas de cada barco:");
		for(Barco b: lBarcos) {
			if(b.getlMareas().size() > 0) {
				System.out.println("Barco: " + b.getNombre() + " Mareas generadas: " + b.getlMareas().size());
			}
		}
	}
	
	private static void ejercicio5(){
		System.out.println("-> EJERCICIO 5 <-");
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaDatos();
            }
        });
	}
	
	public static void main(String[]args) {
		//Cargamos los datos de la base de datos existente. 
		//Si cargamos los datos desde .csv se sustituirán.
		BaseDatos.abrirConexion("gestionbarcos.db");
		lBarcos = BaseDatos.getBarcos();
		lEventos = BaseDatos.getEventos();
		BaseDatos.cerrarConexion();
		// ----------------------
		// EJERCICIOS DEL EXAMEN
		// Podéis comentarlos y descomentarlos para ir probando uno a uno
		// ----------------------
		ejercicio1();
		// ----------------------
		ejercicio3();
		// ----------------------
		ejercicio4();
		// ----------------------
		ejercicio5();
		// ----------------------
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
	/** Método que devuelve un listado de los eventos de cada barco.
	 * @param b Barco a buscar en los eventos.
	 * @return Arraylist de Eventos que cumplan el criterio
	 */
	public static ArrayList<Evento> getEventosBarco(Barco b) {
		ArrayList<Evento> eventosBarco = new ArrayList<Evento>();
		for (Evento e : lEventos) {
			if(e.getCodigoBarco().equals(b.getCodigo())) eventosBarco.add(e);
		}
		return eventosBarco;
	}
}
