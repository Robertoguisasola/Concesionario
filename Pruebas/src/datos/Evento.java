package datos;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Evento{
	private String codigoBarco;
	private GregorianCalendar fecha;
	private TipoEvento tipo;
	
	public Evento(String codigoBarco, GregorianCalendar fecha, TipoEvento tipo) {
		this.codigoBarco = codigoBarco;
		if(fecha == null){	//Si la fecha es nula
			throw new NullPointerException();
		} else if(fecha.compareTo(new GregorianCalendar()) == 1) {	//Si la fecha es posterior a la fecha de hoy
			throw new IllegalArgumentException("Fecha posterior a fecha de hoy");
		} else if(fecha.compareTo(new GregorianCalendar(2010,0,1)) == -1) {	//Si la fecha es anterior a 2010
			throw new IllegalArgumentException("Fecha anterior a 2010");
		} else {
			this.fecha = fecha;
		}
		this.tipo = tipo;
	}

	public String getCodigoBarco() {
		return codigoBarco;
	}

	public void setCodigoBarco(String codigoBarco) {
		this.codigoBarco = codigoBarco;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy kk:mm");
	    fmt.setCalendar(fecha);
	    String dateFormatted = fmt.format(fecha.getTime());
		return codigoBarco + " - " + dateFormatted + " " + tipo.toString();
	}
	
	
}
