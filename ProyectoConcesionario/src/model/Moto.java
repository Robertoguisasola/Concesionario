package model;

public class Moto extends Vehiculo {
	
	//TODO tttt hacer test de moto
	protected boolean estructuraProtectora;

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
	
	protected String estructuraProtectoraString() {
	String estructura;
		
		if (estructuraProtectora) {
			estructura = " con estructura protectora";
		} else {
			estructura = " sin estructura protectora";
		}
		
		return estructura;
	}

	@Override
	public String toString() {
	
		return marca + " " + modelo + " " + getColorString() + " tiene " + caballos + "cv y " + nPlazas + " plazas," + estructuraProtectoraString();
	}

	public String venderMoto() {
		return marca + " " + modelo + " " + getColorString() + estructuraProtectoraString() + ", " + caballos + "cv y " + nPlazas + " plazas";
	}
}
