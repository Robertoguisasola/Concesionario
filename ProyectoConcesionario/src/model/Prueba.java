package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prueba {
	
	private Persona probador;
	private Vehiculo vehiculo;
	private Date fechaInicio;
	private Date fechaFinPermiso;
	public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private String ciudad;
	
	public Prueba(Persona probador, Vehiculo vehiculo, Date fechaInicio, Date fechaFinPermiso, String ciudad) {
		super();
		this.probador = probador;
		this.vehiculo = vehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaFinPermiso = fechaFinPermiso;
		this.ciudad = ciudad;
	}

	public Prueba() {
		super();
		this.probador = null;
		this.vehiculo = null;
		this.fechaInicio = null;
		this.fechaFinPermiso = null;
		this.ciudad = null;
	}

	public Prueba(Prueba p) {
		super();
		this.probador = p.probador;
		this.vehiculo = p.vehiculo;
		this.fechaInicio = p.fechaInicio;
		this.fechaFinPermiso = p.fechaFinPermiso;
		this.ciudad = p.ciudad;
	}

	public Persona getProbador() {
		return probador;
	}

	public void setProbador(Persona probador) {
		this.probador = probador;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinPermiso() {
		return fechaFinPermiso;
	}

	public void setFechaFinPermiso(Date fechaFinPermiso) {
		this.fechaFinPermiso = fechaFinPermiso;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setFechaInicioString (String fechaInicio) throws ParseException {
		this.fechaInicio = df.parse(fechaInicio);
	}
	
	public String getFechaInicioString() {
		return df.format(fechaInicio);
	}
	
	public void setFechaFinPermisoString (String fechaFinPermiso) throws ParseException {
		this.fechaFinPermiso = df.parse(fechaFinPermiso);
	}
	
	public String getFechaFinPermisoString() {
		return df.format(fechaFinPermiso);
	}

	@Override
	public String toString() {
		return "El cliente " + probador.getNombre() + " " + probador.getApellidos() + " con DNI " + probador.getdNI() + " ha solicitado la prueba de " +
				vehiculo.toString() + " el día " + getFechaInicioString() + " hasta el día " + getFechaFinPermisoString() + " en " + ciudad;
	}
}