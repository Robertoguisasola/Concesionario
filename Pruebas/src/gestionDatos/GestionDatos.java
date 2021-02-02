package gestionDatos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import datos.Barco;
import datos.Evento;
import principal.Examen;

public class GestionDatos {

	// ---- ESTRUCTURAS DE DATOS ----

	/** Método que ordena las salidas y entradas (Eventos) de cada barco en función de la fecha. 
	 * Para ello, crea un mapa (HashMap) que tenga como clave el código del barco y como valor 
	 * un conjunto ordenado de todos los eventos que le corresponden. 
	 * Recorre el mapa volcando a consola los eventos de cada barco en el formato solicitado.
	 */
	public static void ordenarEventos() {
		//T3
		HashMap<String, ArrayList<Evento>> mapa = new HashMap<>();

		ArrayList<Barco> barcos = Examen.lBarcos;
		ArrayList<Evento> eventos = Examen.lEventos;

		for(Barco b: barcos) {
			ArrayList<Evento>evBarco = new ArrayList<Evento>();
			for (Evento evento : eventos) {
				if (evento.getCodigoBarco().equals(b.getCodigo())) {
					evBarco.add(evento);
				}
			}
			mapa.put(b.getCodigo(), eventos);

		}

		for (Map.Entry<String, ArrayList<Evento>> entry : mapa.entrySet()) {
			for(Barco b: barcos) {
				if (b.getCodigo().equals(entry.getKey())) {
					System.out.println(b.getNombre() + " - " + b.getOceano() + " - " + b.getTipo().toString());
				}
				for (Evento evento : entry.getValue()) {
					GregorianCalendar cal = evento.getFecha();
					System.out.println(cal.get(Calendar.DAY_OF_MONTH) + "/"+ cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR) + 
							cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + "-" + evento.getTipo().toString());
				}
			}
		}
	}

	// ---- RECURSIVIDAD ----

	/** Ordena la lista completa de objetos de tipo Evento utilizando 
	 * el algoritmo Merge Sort teniendo en cuenta las fechas de salida y entrada. 
	 * @return ArrayList ordenado de Eventos
	 */
	public static ArrayList<Evento> ordenarEventosMergeSort() {
		//T4a

		return null;
	}

	/** Método shell que procesa la lista de eventos completa ordenada (Utiliza el resultado de 4a), 
	 * busque primero una salida y después, recursivamente, llama a una función que busca una entrada posterior del barco. 
	 * Cada vez que esto ocurra genera un objeto de tipo Marea y añádelo a la lista de mareas disponible en el objeto Barco correspondiente.
	 * @param lEventos Listado de mareas ordenado por fecha
	 */
	public static void generaMareas(ArrayList<Evento> lEventos) {
		//T4b

	}
}
