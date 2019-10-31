package model;

import java.util.Date;

public class Trabajador extends Persona{
	
	private int sueldo;

	public Trabajador(String login, String password, String email, String dNI, String nombre, String apellidos,
			Date fechaNacimiento, int sueldo) {
		super(login, password, email, dNI, nombre, apellidos, fechaNacimiento);
		this.sueldo = sueldo;
	}

	public Trabajador() {
		super("", "", "", "", "", "", null);
		this.sueldo = 0;
	}

	public Trabajador(Trabajador t) {
		super(t.login, t.password, t.email, t.dNI, t.nombre, t.apellidos, t.fechaNacimiento);
		this.sueldo = t.sueldo;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Trabajador [sueldo=" + sueldo + ", login=" + login + ", password=" + password + ", email=" + email
				+ ", dNI=" + dNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}


}
