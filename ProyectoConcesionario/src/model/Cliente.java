package model;

import java.util.Date;

public class Cliente extends Persona {

	private long numTarjeta;

	public Cliente(String login, String password, String email, String dNI, String nombre, String apellidos,
			Date fechaNacimiento, long numTarjeta) {
		super(login, password, email, dNI, nombre, apellidos, fechaNacimiento);
		this.numTarjeta = numTarjeta;
	}

	public Cliente() {
		super("", "", "", "", "", "", null);
		this.numTarjeta = 0000000000000000;
	}

	public Cliente(Cliente c) {
		super(c.login, c.password, c.email, c.dNI, c.nombre, c.apellidos, c.fechaNacimiento);
		this.numTarjeta = c.numTarjeta;
	}

	public long getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(long numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos + ", con DNI " + dNI + " y número de tarjeta " + numTarjeta;
	}
}