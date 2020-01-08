package model;

public class Moto extends Vehiculo {
	
	private boolean estructuraProtectora;

	public Moto(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas, int precio, boolean estructuraProtectora) {
		super(marca, modelo, color, caballos, numRuedas, nPlazas, precio);
		this.estructuraProtectora = estructuraProtectora;
	}

	public Moto() {
		super("", "", null, 0, 0, 0, 0);
		this.estructuraProtectora = false;
	}

	public Moto(Moto m) {
		super(m.marca, m.modelo, m.color, m.caballos, m.numRuedas, m.nPlazas, m.precio);
		this.estructuraProtectora = m.estructuraProtectora;
	}

	public boolean isEstructuraProtectora() {
		return estructuraProtectora;
	}

	public void setEstructuraProtectora(boolean estructuraProtectora) {
		this.estructuraProtectora = estructuraProtectora;
	}

	@Override
	public String toString() {
		String estructura;
		
		if (estructuraProtectora) {
			estructura = "con ";
		} else {
			estructura = "sin ";
		}
		return marca + " " + modelo + " " + getColorString() + " tiene " + caballos + "cv y " + nPlazas + " plazas, " + estructura + "estructura protectora";
	}

}
