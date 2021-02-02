package gestionDatos;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import datos.Evento;
import datos.TipoEvento;

/** Clase para la carga de ficheros CSV
 */
public class ProcesoCSV {
	/** Carga los eventos desde eventos.csv
	 * @return Devuelve los eventos cargados en un ArrayList
	 */

	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static ArrayList<Evento> cargarEventos() {
		ArrayList<Evento> lEventos = new ArrayList<>();

		//T1a - Carga de eventos desde eventos.csv

		File f = null;
		Scanner sc = null;

		try {
			f = new File("eventos.csv");
			sc = new Scanner(f);

			while(sc.hasNextLine()) {
				String linea = sc.nextLine();

				String[] campos = linea.split(",");

				String codigoBarco = campos[0];
				Date fecha = df.parse(campos[2]);
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(fecha);
				String tipo = campos[1];

				Evento e = new Evento (codigoBarco, cal, TipoEvento.valueOf(tipo));

				lEventos.add(e);	
			}
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			sc.close();
		}

		return lEventos;
	}
}