package model;

import java.util.Date;

public class Cliente extends Persona {
	
	private int numTarjeta;

	public Cliente(String login, String password, String email, String dNI, String nombre, String apellidos,
			Date fechaNacimiento, int numTarjeta) {
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

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	@Override
	public String toString() {
		return "Cliente [numTarjeta=" + numTarjeta + "]";
	}
}