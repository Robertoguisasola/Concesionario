package model;

import java.util.Date;

public class Trabajador extends Persona{
	
	private int sueldo;
	private boolean isAdmin;

	public Trabajador(String login, String password, String email, String dNI, String nombre, String apellidos,
			Date fechaNacimiento, int sueldo, boolean isAdmin) {
		super(login, password, email, dNI, nombre, apellidos, fechaNacimiento);
		this.sueldo = sueldo;
		this.isAdmin = isAdmin;
	}

	public Trabajador() {
		super("", "", "", "", "", "", null);
		this.sueldo = 0;
		this.isAdmin = false;
	}

	public Trabajador(Trabajador t) {
		super(t.login, t.password, t.email, t.dNI, t.nombre, t.apellidos, t.fechaNacimiento);
		this.sueldo = t.sueldo;
		this.isAdmin = t.isAdmin;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Trabajador [sueldo=" + sueldo + ", login=" + login + ", password=" + password + ", email=" + email
				+ ", dNI=" + dNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}


}
