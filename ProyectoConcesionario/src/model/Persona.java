package model;

import java.util.Date;

public class Persona {
	
	private String dNI;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	
	public Persona(String dNI, String nombre, String apellidos, Date fechaNacimiento) {
		super();
		this.dNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Persona() {
		super();
		this.dNI = "";
		this.nombre = "";
		this.apellidos = "";
		this.fechaNacimiento = null;
	}
	
	public Persona(Persona p) {
		super();
		this.dNI = p.dNI;
		this.nombre = p.nombre;
		this.apellidos = p.apellidos;
		this.fechaNacimiento = p.fechaNacimiento;
	}
	
	public String getdNI() {
		return dNI;
	}
	
	public void setdNI(String dNI) {
		this.dNI = dNI;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}