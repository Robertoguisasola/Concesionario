package datos;

import java.time.temporal.ChronoUnit;

public class Marea {
	private String nombre;
	private Barco barco;
	private Evento salida;
	private Evento entrada;
	private int dias;
	
	public Marea(Barco barco, Evento salida, Evento entrada) {
		this.nombre = "";
		this.barco = barco;
		this.salida = salida;
		this.entrada = entrada;
		if(salida.getFecha().compareTo(entrada.getFecha()) == 1){
			throw new IllegalArgumentException("Fecha salida posterior a fecha entrada");
		}
		this.dias = (int) ChronoUnit.DAYS.between(salida.getFecha().toZonedDateTime().toLocalDate(), entrada.getFecha().toZonedDateTime().toLocalDate());
	}

	public String getNombre() {
		return nombre;
	}

	public Barco getBarco() {
		return barco;
	}

	public Evento getSalida() {
		return salida;
	}

	public Evento getEntrada() {
		return entrada;
	}

	public int getDias() {
		return dias;
	}
}
